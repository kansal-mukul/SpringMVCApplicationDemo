FROM tomcat:8.0.20-jre8
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./target/SpringMVCApplicationDemo-1.0.war /usr/local/tomcat/webapps/SpringMVCApplicationDemo-1.0.war
CMD ["catalina.sh","run"]
