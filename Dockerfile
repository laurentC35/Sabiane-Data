FROM openjdk:11-jre-slim

ADD ./target/sabianedata.jar app.jar

ENTRYPOINT ["java","-jar","./app.jar"]
