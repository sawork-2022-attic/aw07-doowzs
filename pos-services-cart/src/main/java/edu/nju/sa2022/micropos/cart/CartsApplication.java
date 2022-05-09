package edu.nju.sa2022.micropos.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CartsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartsApplication.class, args);
    }

}