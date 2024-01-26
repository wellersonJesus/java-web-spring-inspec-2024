# Estágio de compilação
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

# Copie apenas o arquivo POM inicial para aproveitar o cache ao baixar as dependências
COPY pom.xml .

# Compile o projeto
RUN mvn clean install

# Estágio de criação da imagem final
FROM openjdk:17-jdk-slim

WORKDIR /app

EXPOSE 8080

# Copie apenas os artefatos necessários do estágio de compilação
COPY --from=build /app/target/user-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

