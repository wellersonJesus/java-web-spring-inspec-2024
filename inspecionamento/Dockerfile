# Use an official Ubuntu as a build image
FROM ubuntu:latest AS build

# Install necessary dependencies
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven && \
    rm -rf /var/lib/apt/lists/*

# Set the working directory
WORKDIR /app

# Copy the Maven project files and build the application
COPY . .
RUN mvn clean install

# Use a slim image for the final build
FROM openjdk:17-jdk-slim

# Set the working directory in the new image
WORKDIR /app

# Expose the port the app runs on
EXPOSE 8080

# Copy the JAR file from the build image to the new image
COPY --from=build /app/target/user-0.0.1-SNAPSHOT.jar app.jar

# Define the command to run your application
ENTRYPOINT ["java", "-jar", "app.jar"]
