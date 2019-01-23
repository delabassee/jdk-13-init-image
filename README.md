## Fn Init Image for JDK 13 Early Access 


`tar cf jdk-13ea-init.tar func.init.yaml pom.xml src Dockerfile`

`docker build -f Dockerfile-init -t jdk-13ea-init .`

`fn init --init-image jdk-13ea-init myfunc`


jdk-13ea-init:latest