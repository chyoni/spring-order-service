#!/bin/bash

docker run -d --network ecommerce-network \
    --name order-service \
    -e "spring.cloud.config.uri=http://config-service:8888" \
    -e "spring.rabbitmq.host=rabbitmq" \
    -e "spring.datasource.url=jdbc:mariadb://mariadb:3306/mydb" \
    -e "eureka.client.serviceUrl.defaultZone=http://discovery-service:8761/eureka/" \
    -e "logging.file=/api-logs/orders-ws.log" \
    cwchoiit/order-service:0.0.1