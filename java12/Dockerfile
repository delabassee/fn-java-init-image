FROM fn-cache:latest as cache-stage

FROM maven:3.6.0-jdk-12-alpine as build-stage
WORKDIR /function
ENV MAVEN_OPTS -Dhttp.proxyHost= -Dhttp.proxyPort= -Dhttps.proxyHost= -Dhttps.proxyPort= -Dhttp.nonProxyHosts= -Dmaven.repo.local=/usr/share/maven/ref/repository

ADD pom.xml /function/pom.xml
RUN ["mvn", "package", \
    "dependency:copy-dependencies", \
    "-DincludeScope=runtime", \
    "-Dmdep.prependGroupId=true", \
    "-DoutputDirectory=target" ]

ADD src /function/src
RUN ["mvn", "package"]

FROM openjdk:12-ea-19-jdk-oraclelinux7

COPY --from=build-stage /function/ /function
COPY --from=cache-stage /libfnunixsocket.so /lib

ENTRYPOINT [ "/usr/bin/java", \
    "-Dfile.encoding=UTF-8", \
    "-XX:+UseSerialGC", \
	 "--enable-preview", \
    "-Xshare:on", \
    "-cp", "/function/target/*", \
    "com.fnproject.fn.runtime.EntryPoint" ] 
CMD ["com.example.fn.HelloFunction::handleRequest"]
