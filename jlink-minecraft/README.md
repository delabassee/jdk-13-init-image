
## `jlink` images with Minecraft server

[Default Server](https://www.minecraft.net/en-us/download/server) that Mojang distributes.

### 171M

`RUN /usr/java/openjdk-13/bin/jlink --output /work/java-runtime0 --add-modules $(java --list-modules >&1 | sed 's/@13/,/g' | sed -e ':a' -e 'N' -e '$!ba' -e 's/\n/ /g' | sed 's/ //g')`

### 171M
`RUN /usr/java/openjdk-13/bin/jlink --no-header-files --output /work/java-runtime0.header --add-modules $(java --list-modules >&1 | sed 's/@13/,/g' | sed -e ':a' -e 'N' -e '$!ba' -e 's/\n/ /g' | sed 's/ //g')`

### 171M
`RUN /usr/java/openjdk-13/bin/jlink --no-man-pages --output /work/java-runtime0.man --add-modules $(java --list-modules >&1 | sed 's/@13/,/g' | sed -e ':a' -e 'N' -e '$!ba' -e 's/\n/ /g' | sed 's/ //g')`

### 88M
`RUN /usr/java/openjdk-13/bin/jlink --output /work/java-runtime1  --add-modules java.base,java.compiler,java.desktop,java.management,java.naming,java.rmi,java.scripting,java.sql,jdk.sctp,jdk.unsupported,jdk.zipfs`


### 74M
`RUN /usr/java/openjdk-13/bin/jlink --strip-debug --output /work/java-runtime2  --add-modules java.base,java.compiler,java.desktop,java.management,java.naming,java.rmi,java.scripting,java.sql,jdk.sctp,jdk.unsupported,jdk.zipfs`


### 74M
`RUN /usr/java/openjdk-13/bin/jlink --strip-java-debug-attributes --output /work/java-runtime3  --add-modules java.base,java.compiler,java.desktop,java.management,java.naming,java.rmi,java.scripting,java.sql,jdk.sctp,jdk.unsupported,jdk.zipfs`

### 88M
`RUN /usr/java/openjdk-13/bin/jlink --strip-native-debug-symbols exclude-debuginfo-files --output /work/java-runtime4  --add-modules java.base,java.compiler,java.desktop,java.management,java.naming,java.rmi,java.scripting,java.sql,jdk.sctp,jdk.unsupported,jdk.zipfs`

### 70M
`RUN /usr/java/openjdk-13/bin/jlink --compress=1  --output /work/java-runtime5 --add-modules java.base,java.compiler,java.desktop,java.management,java.naming,java.rmi,java.scripting,java.sql,jdk.sctp,jdk.unsupported,jdk.zipfs`


### 57M
`RUN /usr/java/openjdk-13/bin/jlink --compress=2 --output /work/java-runtime6 --add-modules java.base,java.compiler,java.desktop,java.management,java.naming,java.rmi,java.scripting,java.sql,jdk.sctp,jdk.unsupported,jdk.zipfs`



------

### Native Debug Symbols


* `--strip-native-debug-symbols exclude-debuginfo-files` => strips debug info from native libs and files discarding debug info 
* `--strip-native-debug-symbols keep-debuginfo-files` => strips debug info from native libs and files, keeps debug info in files <filename>.debuginfo 
* `--strip-native-debug-symbols keep-debuginfo-files=foo` => strips debug info from native libs and files, keeps debug info in files <filename>.foo 
* `--strip-native-debug-symbols objcopy=<path/to/objcopy>` => strips debug info from native libs and files, discarding debug info files and using `objcopy` at the provided path. 

Options may be combined (if they make sense). 

`--strip-debug` post this enhancement will strip java debug info from Java classes via (`--strip-java-debug-attributes`, see JDK-8218913) and also strip native debug info on platform.

https://bugs.openjdk.java.net/browse/JDK-8214796


-----

### Debian

* Debian OpenJDK packages

	* [openjdk-11-jdk](https://packages.debian.org/buster/openjdk-11-jdk)
	
	* [openjdk-12-jdk](https://packages.debian.org/source/sid/openjdk-12)
	
	* [openjdk-13-jdk](https://packages.debian.org/bullseye/openjdk-13-jdk)

* [libjvm.so size issue](https://github.com/docker-library/openjdk/issues/217)


