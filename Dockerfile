FROM amazoncorretto:19-al2-jdk
COPY target/IC-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]