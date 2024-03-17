FROM openjdk:17-jdk

WORKDIR /app

COPY target/testesicred-0.0.1-SNAPSHOT.jar /app/testesicred-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "testesicred-0.0.1-SNAPSHOT.jar"]