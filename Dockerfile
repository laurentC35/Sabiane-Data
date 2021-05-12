FROM tomcat:9.0.38-jdk11-openjdk

RUN rm -rf $CATALINA_HOME/webapps/*
ADD src/main/resources/log4j2.xml $CATALINA_HOME/webapps/log4j2.xml
ADD src/main/resources/sabianedata-server.properties $CATALINA_HOME/webapps/sabianedata.properties
ADD ./target/*.war $CATALINA_HOME/webapps/ROOT.war

CMD ["catalina.sh", "run"]