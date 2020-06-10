FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=./build/libs/* 
COPY ${JAR_FILE} stateInfo-0.0.1-SNAPSHOT.jar
EXPOSE 9030
CMD ["java","-jar","stateInfo-0.0.1-SNAPSHOT.jar"]