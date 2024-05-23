FROM ubuntu:latest
LABEL authors="pedro"

FROM openjdk:22-jdk-slim
VOLUME /tmp
ARG JAR_FILE=target/sales-api-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} sales-api.jar
ENTRYPOINT ["java","-jar","/sales-api.jar"]