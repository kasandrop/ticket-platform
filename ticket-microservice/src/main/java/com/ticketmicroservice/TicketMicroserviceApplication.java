package com.ticketmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TicketMicroserviceApplication {

        public static void main(String[] args) {
            SpringApplication.run(TicketMicroserviceApplication.class, args);
        }
}
