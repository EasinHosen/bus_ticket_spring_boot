FROM maven:3.8.6-openjdk-20.ea-b24 AS build
COPY ..
RUN mvn clean package DskipTests

FROM openjdk:18-ea-20-jdk-slim
COPY --from=build /target/bus_ticket_flutter-0.0.1-SNAPSHOT.jar btsb.jar
EXPOSE 8080
ENTRYPOINT["java", "-jar", "btsb.jar"]