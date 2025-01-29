package com.example.inventoryenigma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry // Optional: Enable retry mechanism for deadlock recovery
public class InventoryEnigmaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeadlockDemoApplication.class, args);
    }
}
