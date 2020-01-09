## Fn Init Image for Java 15 EA


### How-to

See [init-images](https://medium.com/fnproject/even-wider-language-support-in-fn-with-init-images-a7a1b3135a6e) details.

`tar cf jlink-init.tar func.init.yaml pom.xml src Dockerfile`

`docker build -f Dockerfile-init -t jlink-init .`

`fn init --init-image jlink-init myfunc`