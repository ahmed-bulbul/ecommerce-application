# Use AdoptOpenJDK 17 as the base image
FROM adoptopenjdk:17-jdk-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged JAR file into the container at /app
COPY target/ecommerce-0.0.1-SNAPSHOT.jar /app/ecommerce.jar

# Expose the port that your Spring Boot application uses (default is 8080)
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "ecommerce.jar"]
