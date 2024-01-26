# Estágio de compilação
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

# Copie apenas o arquivo POM inicial para aproveitar o cache ao baixar as dependências
COPY inspecionamento/pom.xml .

# Baixe as dependências antes de copiar todo o código-fonte
RUN mvn dependency:go-offline

# Compile o projeto
RUN mvn clean install

# Estágio de criação da imagem final
FROM openjdk:17-jdk-slim

WORKDIR /app

EXPOSE 8080

# Copie apenas os artefatos necessários do estágio de compilação
COPY --from=build /app/inspecionamento/target/user-0.0.1-SNAPSHOT.jar app.jar

# Se necessário, adicione as pastas com recursos (por exemplo, arquivos de configuração) ao JAR
# COPY --from=build /app/inspecionamento/src/main/resources /app/resources

ENTRYPOINT ["java", "-jar", "app.jar"]

