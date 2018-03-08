FROM java:latest

ENV locator_host=localhost
ADD test-app-0.0.1-SNAPSHOT.jar /opt
EXPOSE 8080

ENTRYPOINT java -jar /opt/test-app-0.0.1-SNAPSHOT.jar --locatorHost=$locator_host