FROM openjdk:11.0.16
ADD build/libs/Resource_Project-0.0.1-SNAPSHOT.jar /Resource_Project-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "/Resource_Project-0.0.1-SNAPSHOT.jar"]
