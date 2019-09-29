## Fn init-image to measure the various JRE sizes

### Java 13

|jlink flags|
|---|---|---|---|
|JDK 13|330 MB|100%||
|`--add-modules $(java --list-modules)`|178 MB|54%|100%|
|`--add-modules $(jdeps --print-module-deps ...)`|50 MB|15%|28%|
|`... --no-header-files --no-man-pages --strip-java-debug-attributes`|44 MB|13%|25%|
|`... --compress=1`|37 MB|11%|21%|
|`... --compress=2`|34 MB|10%|19%|

[JDK-8218913 Rename --strip-debug jlink plugin](https://bugs.openjdk.java.net/browse/JDK-8218913)
