## Fn init-image to measure the various JRE sizes

### Java 13

|jlink Flags|MB|%]
|---|---|---|
JDK 13|330|100|
|`--add-modules $(java --list-modules)`|178|54|
|`--add-modules $(jdeps --print-module-deps ...)`|50|15|
|`... --no-header-files --no-man-pages --strip-java-debug-attributes`|44|13|
|`... --compress=1`|37|11|
|`... --compress=2`|34|10|

[JDK-8218913 Rename --strip-debug jlink plugin](https://bugs.openjdk.java.net/browse/JDK-8218913)
