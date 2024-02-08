FROM openjdk:17-jdk AS build

WORKDIR /app
COPY . .

RUN ./mvnw clean install

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /app/target/inspect-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
