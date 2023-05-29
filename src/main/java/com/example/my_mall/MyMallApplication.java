package com.example.my_mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class MyMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyMallApplication.class, args);
    }

}
