FROM delabassee/fn-cache:latest as cache-stage

#FROM maven:3.6.2-jdk-14-alpine as build-stage
FROM openjdk:14-alpine as build-stage
WORKDIR /function
RUN wget --no-check-certificate https://apache.forsale.plus/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
#        ^^^ Don't do this at home!!

RUN tar -zxvf apache-maven-3.6.3-bin.tar.gz

ENV PATH="/function/apache-maven-3.6.3/bin:${PATH}"

ENV MAVEN_OPTS -Dhttp.proxyHost= -Dhttp.proxyPort= -Dhttps.proxyHost= -Dhttps.proxyPort= -Dhttp.nonProxyHosts= -Dmaven.repo.local=/usr/share/maven/ref/repository
ADD pom.xml /function/pom.xml
ADD src /function/src
RUN ["mvn", "package"]

RUN ["mvn", "package", \
    "dependency:copy-dependencies", \
    "-DincludeScope=runtime", \
    "-Dmdep.prependGroupId=true", \
    "-DoutputDirectory=target" ]

#RUN /usr/java/openjdk-14/bin/jlink --compress=2 --no-header-files --no-man-pages --strip-debug --output /function/fnjre --add-modules $(/usr/java/openjdk-14/bin/jdeps --print-module-deps /function/target/function.jar)

RUN /opt/openjdk-14/bin/jlink --compress=2 --no-header-files --no-man-pages --strip-java-debug-attributes --output /function/fnjre --add-modules $(/opt/openjdk-14/bin/jdeps --print-module-deps /function/target/function.jar)

# --strip-debug --> java.io.IOException: Cannot run program "objcopy": error=2, No such file or directory

FROM alpine:latest
WORKDIR /function

COPY --from=build-stage /function/target/*.jar /function/
COPY --from=build-stage /function/fnjre/ /function/fnjre/
COPY --from=cache-stage /libfnunixsocket.so /lib

ENTRYPOINT [ "/function/fnjre/bin/java", \
    "--enable-preview", \
    "-cp", "/function/*", \
    "com.fnproject.fn.runtime.EntryPoint" ]

CMD ["com.example.fn.HelloFunction::handleRequest"]
#CMD /bin/ash