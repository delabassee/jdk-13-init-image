## Fn init-image to measure the various JRE sizes

### Java 13

* *17 8MB* `--add-modules $(java --list-modules)`
* *50 MB* `--add-modules $(jdeps --print-module-deps ...)`
* *44 MB* `--no-header-files --no-man-pages --strip-java-debug-attributes ---add-modules $(jdeps --print-module-deps ...)`
* *37 MB* `--no-header-files --no-man-pages --strip-java-debug-attributes --compress=1 --add-modules $(jdeps --print-module-deps ...)`
* *34 MB* `--no-header-files --no-man-pages --strip-java-debug-attributes --compress=2 --add-modules $(jdeps --print-module-deps ...)`


[JDK-8218913 - Rename --strip-debug jlink plugin](https://bugs.openjdk.java.net/browse/JDK-8218913)
