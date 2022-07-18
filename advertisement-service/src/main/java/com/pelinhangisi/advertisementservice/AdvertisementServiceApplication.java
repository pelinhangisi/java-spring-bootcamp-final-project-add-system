package com.pelinhangisi.advertisementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdvertisementServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdvertisementServiceApplication.class,args);
    }
}
