FROM gradle:jre11-slim as builder

USER root

COPY . /application
WORKDIR /application

RUN gradle build

RUN mv build/libs/*.jar /tmp/application.jar

FROM openjdk:11-jre-slim

COPY --from=builder /tmp/application.jar /

EXPOSE 8080
CMD java -jar /application.jar