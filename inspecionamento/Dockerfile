# Primeira fase de construção
FROM ubuntu:latest AS build

# Atualiza e instala o JDK
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk

# Configuração do ambiente de compilação
WORKDIR /app
COPY . .
RUN apt-get install -y maven
RUN mvn clean install

# Segunda fase para a execução
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copia o artefato construído da fase anterior
COPY --from=build /target/user-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta 8080
EXPOSE 8080

# Comando de execução
ENTRYPOINT ["java", "-jar", "app.jar"]
