# Estágio de Construção
FROM maven:3.8.4-openjdk-17 AS build

# Defina o diretório de trabalho para o projeto Java
WORKDIR /usr/src/app

# Copie o arquivo POM e o diretório src
COPY /home/well/Documentos/projetos/java-web-spring-inspec-2024/pom.xml .
COPY /home/well/Documentos/projetos/java-web-spring-inspec-2024/inspecionamento src

# Execute o comando Maven para construir o projeto
RUN mvn clean install

# Estágio Final
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho para o aplicativo final
WORKDIR /app

# Exponha a porta 8080
EXPOSE 8080

# Copie o arquivo JAR construído do estágio de construção
COPY --from=build /usr/src/app/target/inspect-0.0.1-SNAPSHOT.jar app.jar

# Comando de entrada para iniciar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]

