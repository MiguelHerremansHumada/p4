package com.ligaendesa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = "com.ligaendesa")
public class LigaEndesaApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(LigaEndesaApiApplication.class, args);
    }
}
