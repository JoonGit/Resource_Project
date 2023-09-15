FROM openjdk:11
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} Resource_Project-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Resource_Project-0.0.1-SNAPSHOT.jar --DBURL=jdbc:mysql://mydb.cjgeoyu2bayw.eu-north-1.rds.amazonaws.com:3306/resource_project --DBUSER=admin --DBPASSWORD=qwer1234"]