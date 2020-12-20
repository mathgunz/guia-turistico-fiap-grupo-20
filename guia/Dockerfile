FROM openjdk:11-jdk
MAINTAINER cliente
WORKDIR /app
COPY build/libs/guia-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]