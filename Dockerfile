FROM openjdk:11-jre-slim

ADD ./target/*.war app.jar

ENTRYPOINT ["java","-jar","/app.jar"]