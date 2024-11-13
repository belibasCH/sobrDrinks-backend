# Stage 1: Build the application using the Pi4J builder image
FROM pi4j/pi4j-builder:2.0 AS builder

# Set the working directory
WORKDIR /build

# Copy the source code into the container
COPY . /build

# Build the application using Gradle
RUN gradle build

# Stage 2: Create the final image
FROM arm64v8/openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built application from the builder stage
COPY --from=builder /build/target/*.jar /app/app.jar

# Copy any required native libraries (if applicable)
COPY --from=builder /build/target/lib/*.so /usr/lib/

# Expose the port your app runs on
EXPOSE 8224

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
