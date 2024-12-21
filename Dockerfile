FROM maven:3.9.9-amazoncorretto-21-alpine AS build
COPY src /forum-hub-alura-build/src
COPY pom.xml /forum-hub-alura-build
WORKDIR /forum-hub-alura-build
RUN mvn clean package

FROM openjdk:21
COPY --from=build /forum-hub-alura-build/target/*.jar /forum-hub-alura-image/app.jar
WORKDIR /forum-hub-alura-image
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
