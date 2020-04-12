FROM openjdk:8
VOLUME /tmp
ADD target/aggregator-0.0.1-SNAPSHOT.jar aggregator.jar
EXPOSE 8099
ENTRYPOINT ["java", "-jar", "aggregator.jar"]