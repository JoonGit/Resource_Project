FROM openjdk:11
ARG JAR_FILE=/build/libs/Resource_Project-0.0.1-SNAPSHOT.jar
ARG DBURL=jdbc:mysql://mydb.cjgeoyu2bayw.eu-north-1.rds.amazonaws.com:3306/resource_project
ARG DBUSER=admin
ARG DBPASSWORD=qwer1234
COPY ${JAR_FILE} Resource_Project-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Resource_Project-0.0.1-SNAPSHOT.jar --"]