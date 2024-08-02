FROM openjdk:17-alpine

COPY target/TechForb-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]