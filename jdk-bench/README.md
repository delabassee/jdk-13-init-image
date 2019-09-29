## Fn init-image to measure the various JRE sizes

### Java 13

|Flags|MB| 
|---|---|
JDK 13|330|
|`--add-modules $(java --list-modules)`|178|
|`--add-modules $(jdeps --print-module-deps ...)`|50|
|`... --no-header-files --no-man-pages --strip-java-debug-attributes`|44|
|`... --compress=1`|37|
|`... --compress=2`|34|

[JDK-8218913 Rename --strip-debug jlink plugin](https://bugs.openjdk.java.net/browse/JDK-8218913)
