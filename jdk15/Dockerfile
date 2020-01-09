FROM delabassee/fn-cache:latest as cache-stage

FROM debian:bullseye-slim as build-stage

RUN apt-get update
RUN apt-get install -y wget
#RUN apt-get install -y maven
WORKDIR /function
RUN wget --no-check-certificate https://apache.forsale.plus/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
RUN wget --no-check-certificate https://download.java.net/java/early_access/jdk15/4/GPL/openjdk-15-ea+4_linux-x64_bin.tar.gz
#        ^^^ Don't do this at home!!

RUN tar -xvf openjdk-15-ea+4_linux-x64_bin.tar.gz
RUN mkdir -p /usr/lib/jvm/jdk-15
RUN mv jdk-15/ /usr/lib/jvm/
RUN update-alternatives --install "/usr/bin/java" "java" "/usr/lib/jvm/jdk-15/bin/java" 1 
RUN update-alternatives --install "/usr/bin/javac" "javac" "/usr/lib/jvm/jdk-15/bin/javac" 1

RUN tar -xvf apache-maven-3.6.3-bin.tar.gz
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

RUN /usr/lib/jvm/jdk-15/bin/jlink --output fn_java_runtime --add-modules $(/usr/lib/jvm/jdk-15/bin/jdeps --print-module-deps /function/target/function.jar)

FROM debian:bullseye-slim as run-stage

WORKDIR /function

COPY --from=build-stage /function/target/*.jar /function/
COPY --from=build-stage /function/fn_java_runtime/ /function/fn_java_runtime/
COPY --from=cache-stage /libfnunixsocket.so /lib

ENTRYPOINT [ "/function/fn_java_runtime/bin/java", \
    "--enable-preview", \
    "-cp", "/function/*", \
    "com.fnproject.fn.runtime.EntryPoint" ]

CMD ["com.example.fn.HelloFunction::handleRequest"]

