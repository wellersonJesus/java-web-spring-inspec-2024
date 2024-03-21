# Estágio 1: Construção
FROM openjdk:8-jdk-alpine AS build

EXPOSE 8081

RUN apk --no-cache add curl tar bash git

ARG MAVEN_VERSION=3.6.3
ARG USER_HOME_DIR="/root"

RUN mkdir -p /usr/share/maven && \
    curl -fsSL https://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz | tar -xzC /usr/share/maven --strip-components=1 && \
    ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"
ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"

WORKDIR /usr/app

COPY . .

RUN if [ -e docker-entrypoint.sh ]; then chmod +x docker-entrypoint.sh; else echo "File docker-entrypoint.sh not found"; fi

WORKDIR /usr/tmp
RUN git clone https://github.com/wellersonJesus/java-web-spring-inspec-2024.git --branch prod_II .

RUN cp -r /usr/tmp/* /usr/app/ && rm -rf /usr/tmp

RUN mvn -f /usr/app clean package -DskipTests -Dmaven.compiler.source=1.8 -Dmaven.compiler.target=1.8

# Estágio 2: Execução
FROM openjdk:8-jdk-alpine

WORKDIR /usr/app

COPY --from=build /usr/app/target/inspect-0.0.1-SNAPSHOT.jar /usr/app/app.jar

EXPOSE 8081

# Se desejar, você pode manter o ENTRYPOINT, mas por enquanto vamos comentar
# ENTRYPOINT ["/usr/app/docker-entrypoint.sh"]

CMD ["java", "-jar", "app.jar"]
