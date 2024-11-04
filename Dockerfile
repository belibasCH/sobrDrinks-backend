# Use an official OpenJDK runtime as a parent image  use correto 21
FROM amazoncorretto:21


# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file into the container
COPY build/libs/*.jar app.jar

# Expose the port your app runs on
EXPOSE 8224

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
