# Use a imagem OpenJDK 8 com Alpine Linux como base
FROM openjdk:8-jdk-alpine

# Expor a porta 8080
EXPOSE 8080

# Instalar as dependências necessárias
RUN apk --no-cache add curl tar bash git

# Definir argumentos para a versão do Maven e o diretório do usuário
ARG MAVEN_VERSION=3.6.3
ARG USER_HOME_DIR="/root"

# Configurar o Maven
RUN mkdir -p /usr/share/maven && \
    curl -fsSL https://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz | tar -xzC /usr/share/maven --strip-components=1 && \
    ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

# Configurar variáveis de ambiente do Maven
ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"
ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"

# Criar diretório para a aplicação
WORKDIR /usr/app

# Copiar todos os arquivos do diretório local para o contêiner
COPY . .

# Verificar se o arquivo docker-entrypoint.sh existe antes de aplicar permissões
RUN if [ -e docker-entrypoint.sh ]; then chmod +x docker-entrypoint.sh; else echo "File docker-entrypoint.sh not found"; fi

# Criar diretório temporário para clonar o repositório Git
WORKDIR /usr/tmp
RUN git clone https://github.com/wellersonJesus/java-web-spring-inspec-2024.git --branch prod_II .

# Mover arquivos clonados para o diretório de trabalho
RUN cp -r /usr/tmp/* /usr/app/ && rm -rf /usr/tmp

# Compilar o projeto Maven especificando a versão do Java
RUN mvn -f /usr/app clean package -DskipTests -Dmaven.compiler.source=1.8 -Dmaven.compiler.target=1.8

# Configurar o ponto de entrada (se necessário)
# ENTRYPOINT ["/usr/app/docker-entrypoint.sh"]
