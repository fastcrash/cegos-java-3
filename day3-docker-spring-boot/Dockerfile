# Basis-Image mit JDK
FROM eclipse-temurin:17-jdk-alpine

# Arbeitsverzeichnis setzen
WORKDIR /app

# Abhängigkeiten & Build-Artefakt kopieren
COPY target/day3-docker-spring-boot-0.0.1-SNAPSHOT.jar app.jar

# Startbefehl
ENTRYPOINT ["java","-jar","app.jar","-web -webAllowOthers -tcp -tcpAllowOthers -browser"]

# Port freigeben
EXPOSE 8080
