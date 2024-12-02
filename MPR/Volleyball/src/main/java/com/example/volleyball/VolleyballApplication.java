package com.example.volleyball;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class VolleyballApplication {

    public static void main(String[] args) {
        SpringApplication.run(VolleyballApplication.class, args);

    }

}
