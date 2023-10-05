FROM openjdk:20-ea-1-jdk-slim
VOLUME /tmp
COPY target/order-service-0.0.1.jar OrderService.jar
ENTRYPOINT ["java", "-jar", "OrderService.jar"]