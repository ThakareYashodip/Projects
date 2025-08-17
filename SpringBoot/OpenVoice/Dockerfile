FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/OpenVoice-0.0.1-SNAPSHOT.jar OpenVoiceApp.jar

ENTRYPOINT ["java", "-jar", "OpenVoiceApp.jar"]
