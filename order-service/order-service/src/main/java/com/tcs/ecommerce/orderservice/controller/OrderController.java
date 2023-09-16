package com.tcs.ecommerce.orderservice.controller;


import com.tcs.ecommerce.orderservice.model.Order;
import com.tcs.ecommerce.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public ResponseEntity<Order> addOrder(@RequestBody Order order)
    {
        Order response=this.orderService.add(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/")
    public ResponseEntity<List<Order>> allOrder()
    {
        List<Order> response=this.orderService.all();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id)
    {
        Order response=this.orderService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<List<Order>> getOrderByProduct(@PathVariable Long id)
    {
        List<Order> response=this.orderService.getOrderByProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id)
    {
        this.orderService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id,@RequestBody Order order)
    {
        Order response=this.orderService.update(id,order);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
