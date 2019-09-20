FROM delabassee/fn-cache:latest as cache-stage

FROM maven:3.6.0-jdk-12-alpine as build-stage
WORKDIR /function
ENV MAVEN_OPTS -Dhttp.proxyHost= -Dhttp.proxyPort= -Dhttps.proxyHost= -Dhttps.proxyPort= -Dhttp.nonProxyHosts= -Dmaven.repo.local=/usr/share/maven/ref/repository
ADD pom.xml /function/pom.xml
ADD src /function/src
RUN ["mvn", "package"]

RUN ["mvn", "package", \
    "dependency:copy-dependencies", \
    "-DincludeScope=runtime", \
    "-Dmdep.prependGroupId=true", \
    "-DoutputDirectory=target" ]

RUN /opt/openjdk-12/bin/jlink --compress=2 --no-header-files --no-man-pages --strip-debug --output /function/fnjre --add-modules $(/opt/openjdk-12/bin/jdeps --print-module-deps /function/target/function.jar)

###############

FROM alpine:latest
WORKDIR /function

COPY --from=build-stage /function/target/*.jar /function/
COPY --from=build-stage /function/fnjre/ /function/fnjre/
COPY --from=cache-stage /libfnunixsocket.so /lib

ENTRYPOINT [ "/function/fnjre/bin/java", \
    "-XX:+UseSerialGC", \
    "--enable-preview", \
##    "-Xshare:on", \
    "-cp", "/function/*", \
    "com.fnproject.fn.runtime.EntryPoint" ]

CMD ["com.example.fn.HelloFunction::handleRequest"]
