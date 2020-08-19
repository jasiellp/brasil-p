FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","-Dserver.port=$PORT $JAVA_OPTS -jar target/brasil-prev-jasiel.jar"]