package com.demo.RestApi.controller;

import com.demo.RestApi.entity.Order;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @PostMapping("/make")
    public String makeOrder( @RequestBody Order order){
                return order.toString();
    }

    @GetMapping("/get/{productName}")
    public String getOrderByProductName(@PathVariable String productName ){
            return productName;
    }


    @GetMapping("/get")
    public String getOrderByProductNameUsingParams(@RequestParam String customerName, @RequestParam String productName ){
        return "customerName : "+ customerName +"\n" +  "productName : "+ productName ;
    }

}
