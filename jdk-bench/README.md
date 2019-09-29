## Fn init-image to measure the various JRE sizes

### Java 13

* *330 MB* JDK as-is
* *178 MB* `--add-modules $(java --list-modules)`
* *50 MB* `--add-modules $(jdeps --print-module-deps ...)`
* *44 MB* `--no-header-files --no-man-pages --strip-java-debug-attributes ---add-modules $(jdeps --print-module-deps ...)`
* *37 MB* `--no-header-files --no-man-pages --strip-java-debug-attributes --compress=1 --add-modules $(jdeps --print-module-deps ...)`
* *34 MB* `--no-header-files --no-man-pages --strip-java-debug-attributes --compress=2 --add-modules $(jdeps --print-module-deps ...)`

|MB |   | 
|---|---|
|330|JDK 13|
|178|`--add-modules $(java --list-modules)`|
|50|`--add-modules $(jdeps --print-module-deps ...)`|
|44|`... --no-header-files --no-man-pages --strip-java-debug-attributes`|
|37|`... --compress=1`|
|34|`... --compress=2`|

[JDK-8218913 Rename --strip-debug jlink plugin](https://bugs.openjdk.java.net/browse/JDK-8218913)
