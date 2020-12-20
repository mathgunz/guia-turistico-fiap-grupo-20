FROM openjdk:11-jdk
MAINTAINER controle-guia-turistico
WORKDIR /app
COPY build/libs/controle-guia-turistico-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]