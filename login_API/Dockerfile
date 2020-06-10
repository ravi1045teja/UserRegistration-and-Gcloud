

FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=./build/libs/* 
COPY ${JAR_FILE} login-0.0.1-SNAPSHOT.jar
EXPOSE 9010
CMD ["java","-jar","login-0.0.1-SNAPSHOT.jar"]