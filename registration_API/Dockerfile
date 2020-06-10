
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=./build/libs/* 
COPY ${JAR_FILE} registration-0.0.1-SNAPSHOT.jar
EXPOSE 8090 
CMD ["java","-jar","registration-0.0.1-SNAPSHOT.jar"]