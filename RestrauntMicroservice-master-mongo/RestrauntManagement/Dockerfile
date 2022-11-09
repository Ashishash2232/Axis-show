FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} springweb.jar
ENTRYPOINT ["java","-jar","/springweb.jar"]