FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install 

FROM openjdk:17-jdk-slim
FROM maven:3-jdk-11 as builder
FROM openjdk:11-slim as runtime

EXPOSE 8080

COPY --from=build /app/inspecionamento/target/user-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]

