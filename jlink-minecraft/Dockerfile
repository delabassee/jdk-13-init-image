FROM openjdk:13 as build-stage
WORKDIR /work
#RUN curl https://www-eu.apache.org/dist/maven/maven-3/3.6.2/binaries/apache-maven-3.6.2-bin.tar.gz -o apache-maven-3.6.2-bin.tar.gz 
#RUN tar -zxvf apache-maven-3.6.2-bin.tar.gz

RUN /usr/java/openjdk-13/bin/jlink --output /work/java-runtime0 --add-modules $(java --list-modules >&1 | sed 's/@13/,/g' | sed -e ':a' -e 'N' -e '$!ba' -e 's/\n/ /g' | sed 's/ //g')
#171M

RUN /usr/java/openjdk-13/bin/jlink --no-header-files --output /work/java-runtime0.header --add-modules $(java --list-modules >&1 | sed 's/@13/,/g' | sed -e ':a' -e 'N' -e '$!ba' -e 's/\n/ /g' | sed 's/ //g')
#171M

RUN /usr/java/openjdk-13/bin/jlink --no-man-pages --output /work/java-runtime0.man --add-modules $(java --list-modules >&1 | sed 's/@13/,/g' | sed -e ':a' -e 'N' -e '$!ba' -e 's/\n/ /g' | sed 's/ //g')
#171M

RUN /usr/java/openjdk-13/bin/jlink --output /work/java-runtime1  --add-modules java.base,java.compiler,java.desktop,java.management,java.naming,java.rmi,java.scripting,java.sql,jdk.sctp,jdk.unsupported,jdk.zipfs
#88M

RUN /usr/java/openjdk-13/bin/jlink --strip-debug --output /work/java-runtime2  --add-modules java.base,java.compiler,java.desktop,java.management,java.naming,java.rmi,java.scripting,java.sql,jdk.sctp,jdk.unsupported,jdk.zipfs
#74M

RUN /usr/java/openjdk-13/bin/jlink --strip-java-debug-attributes --output /work/java-runtime3  --add-modules java.base,java.compiler,java.desktop,java.management,java.naming,java.rmi,java.scripting,java.sql,jdk.sctp,jdk.unsupported,jdk.zipfs
#74M

RUN /usr/java/openjdk-13/bin/jlink --strip-native-debug-symbols exclude-debuginfo-files --output /work/java-runtime4  --add-modules java.base,java.compiler,java.desktop,java.management,java.naming,java.rmi,java.scripting,java.sql,jdk.sctp,jdk.unsupported,jdk.zipfs

RUN /usr/java/openjdk-13/bin/jlink --compress=1  --output /work/java-runtime5 --add-modules java.base,java.compiler,java.desktop,java.management,java.naming,java.rmi,java.scripting,java.sql,jdk.sctp,jdk.unsupported,jdk.zipfs
#70M

RUN /usr/java/openjdk-13/bin/jlink --compress=2 --output /work/java-runtime6 --add-modules java.base,java.compiler,java.desktop,java.management,java.naming,java.rmi,java.scripting,java.sql,jdk.sctp,jdk.unsupported,jdk.zipfs
#57M


FROM oraclelinux:8-slim
WORKDIR /work
ADD eula.txt /work/eula.txt
ADD server.jar /work/server.jar

COPY --from=build-stage /work/java-runtime0 /work/java-runtime0
COPY --from=build-stage /work/java-runtime0.header /work/java-runtime0.header
COPY --from=build-stage /work/java-runtime0.man /work/java-runtime0.man
COPY --from=build-stage /work/java-runtime1 /work/java-runtime1
COPY --from=build-stage /work/java-runtime2 /work/java-runtime2
COPY --from=build-stage /work/java-runtime3 /work/java-runtime3
COPY --from=build-stage /work/java-runtime4 /work/java-runtime4
COPY --from=build-stage /work/java-runtime5 /work/java-runtime5
COPY --from=build-stage /work/java-runtime6 /work/java-runtime6

CMD /bin/bash


#CMD ["com.example.fn.HelloFunction::handleRequest"]
#CMD /bin/ash
#java-runtime/bin/java -jar server.jar -nogui