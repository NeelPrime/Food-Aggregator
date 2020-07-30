#Build the app using Maven
#FROM maven:3.6.0-jdk-8-alpine
#ADD pom.xml /
#RUN mvn verify clean
### build after dependencies are down so it wont redownload unless the POM changes
#ADD . /
#RUN mvn package


FROM openjdk:8-jdk-alpine
VOLUME /root
ADD target/FoodAggregator-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]