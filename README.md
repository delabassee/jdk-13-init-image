## Fn Init Image for JDK 13 Early Access 

See [init-images](https://medium.com/fnproject/even-wider-language-support-in-fn-with-init-images-a7a1b3135a6e) details.


`tar cf jdk-13ea-init.tar func.init.yaml pom.xml src Dockerfile`

`docker build -f Dockerfile-init -t jdk-13ea-init .`

`fn init --init-image jdk-13ea-init myfunc`


jdk-13ea-init:latest
