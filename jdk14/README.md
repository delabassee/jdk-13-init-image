## Fn Init Image for Java 12 / JLink

See [init-images](https://medium.com/fnproject/even-wider-language-support-in-fn-with-init-images-a7a1b3135a6e) details.

See [image size comparaison](https://docs.google.com/spreadsheets/d/15wjE_2eGGWfZFMI9Dv4prlW3caRQoZqYc0Y8uGVMVQI/edit#gid=0).

See [sandbox](https://github.com/delabassee/jlink-func-test).


`tar cf jlink-init.tar func.init.yaml pom.xml src Dockerfile`

`docker build -f Dockerfile-init -t jlink-init .`

`fn init --init-image jlink-init myfunc`


jlink-init:latest

:warning: EA modules are appended with *"@ea12"* postfix!
