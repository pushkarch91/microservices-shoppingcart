FROM openjdk:21
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} configserver.jar
ENTRYPOINT ["java", "-jar", "/configserver.jar"]
EXPOSE 9296