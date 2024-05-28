FROM openjdk:17-jdk-slim
WORKDIR /app
COPY ./target/backend-virtual-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8003
ENTRYPOINT ["java", "-jar", "/app/app.jar"]