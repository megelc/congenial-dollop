FROM eclipse-temurin:17-jre-alpine
MAINTAINER megel.dk
COPY target/dollop-0.0.1-SNAPSHOT.jar dollop-server.jar
ENTRYPOINT ["java","-jar","/dollop-server.jar"]