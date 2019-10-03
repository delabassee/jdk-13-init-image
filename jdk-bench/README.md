## Fn init-image to measure the various JRE sizes

Use this [Google Sheet](https://docs.google.com/spreadsheets/d/1KkpZDQ8nNmpMWj85c99VLZpGDIArJiZGzUKQJrxP3J4/edit#gid=0).

### Java 13

| | | | |
|---|---|---|---|
|JDK 13|316 MB|100%||
|`--add-modules $(java --list-modules)`|178 MB|56%|100%|
|`--add-modules $(jdeps --print-module-deps ...)`|50 MB|16%|28%|
|`... --no-header-files --no-man-pages --strip-java-debug-attributes`|44 MB|14%|25%|
|`... --compress=1`|37 MB|12%|21%|
|`... --compress=2`|34 MB|11%|19%|

[JDK-8218913 Rename --strip-debug jlink plugin](https://bugs.openjdk.java.net/browse/JDK-8218913)
