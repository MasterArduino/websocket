package com.producer.producersocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@SpringBootApplication
@ComponentScan(basePackages = "com.producer.producersocket.config")

public class ProducersocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducersocketApplication.class, args);
    }
}