#
# Build stage
#
#FROM maven:3.6.0-jdk-11-slim AS build
#COPY src /home/app/src
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package
FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /opt/app
ARG JAR_FILE=target/JumiaServices-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
#
# Package stage
#
#FROM openjdk:11-jre-slim
#COPY --from=build /home/app/target/JumiaServices-0.0.1-SNAPSHOT.jar /usr/local/lib/JumiaServices.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/usr/local/lib/JumiaServices.jar"]