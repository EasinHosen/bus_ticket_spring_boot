FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
RUN apt-get update && apt-get install -y mysql-client
COPY --from=build /target/bus_ticket_flutter-0.0.1-SNAPSHOT.jar btsb.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","btsb.jar"]