FROM maven:3.9.9-amazoncorretto-21-alpine AS build

ARG DIRECTORY-ROOT=/forum-hub-alura-build
ARG SOURCE-DIRECTORY-ROOT=/forum-hub-alura-build/src

COPY src ${SOURCE-DIRECTORY-ROOT}
COPY pom.xml ${DIRECTORY-ROOT}

WORKDIR ${DIRECTORY-ROOT}
RUN mvn clean package

FROM openjdk:21

ARG IMPORT-JAR-FROM-BUILD=/forum-hub-alura-build/target/*.jar
ARG JAR-DIRECTORY-APP=/forum-hub-alura-image/app.jar
ARG IMAGE-DIRECTORY-IMAGE=/forum-hub-alura-image

COPY --from=build ${IMPORT-JAR-FROM-BUILD} ${JAR-DIRECTORY-APP}

WORKDIR ${IMAGE-DIRECTORY-IMAGE}

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]