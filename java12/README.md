## Fn Init Image for Java 12 - `java12-init`

`tar cf java12-init.tar func.init.yaml pom.xml src Dockerfile`

`docker build -f Dockerfile-init -t java12-init .`

`fn init --init-image java12-init myfunc`
