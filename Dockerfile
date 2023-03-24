FROM amazoncorretto:19-al2-jdk
MAINTAINER IC
COPY target/IC-0.0.1-SNAPSHOT.jar ic-app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]