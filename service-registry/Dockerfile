FROM openjdk:21
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} serviceregistry.jar
ENTRYPOINT ["java", "-jar", "/serviceregistry.jar"]
EXPOSE 8761