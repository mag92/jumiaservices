#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
COPY sample.db /home/app/sample.db
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/JumiaServices-0.0.1-SNAPSHOT.jar /usr/local/lib/JumiaServices.jar
COPY --from=build /home/app/sample.db /
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/JumiaServices.jar"]