FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app
COPY target/day3-docker-github-spring-boot-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
