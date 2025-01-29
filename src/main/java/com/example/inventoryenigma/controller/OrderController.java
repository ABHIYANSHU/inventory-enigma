package com.example.inventoryenigma.controller;

import com.example.deadlockdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/process-a")
    public String processOrderA() {
        orderService.processOrder("itemA", "itemB");
        return "Order A processed!";
    }

    @PostMapping("/process-b")
    public String processOrderB() {
        orderService.processOrder("itemB", "itemA");
        return "Order B processed!";
    }
}
