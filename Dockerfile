FROM alpine:edge

VOLUME /tmp

ADD target/DemoApplication.jar /tmp/DemoApplication.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/tmp/DemoApplication.jar"]