# Estágio de compilação
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app
COPY . .

# Execute a instalação com clean para garantir que as dependências sejam baixadas novamente se necessário
RUN mvn clean install

# Estágio de criação da imagem final
FROM openjdk:17-jdk-slim

WORKDIR /app

EXPOSE 8080

# Copie apenas os artefatos necessários do estágio de compilação
COPY --from=build /app/inspecionamento/target/user-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

