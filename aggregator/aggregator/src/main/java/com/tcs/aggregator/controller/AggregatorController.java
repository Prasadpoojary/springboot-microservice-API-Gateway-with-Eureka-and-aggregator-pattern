package com.tcs.aggregator.controller;

import com.tcs.aggregator.dto.Aggregator;
import com.tcs.aggregator.dto.Order;
import com.tcs.aggregator.dto.Product;
import com.tcs.aggregator.dto.Users;
import com.tcs.aggregator.feign.OrderClient;
import com.tcs.aggregator.feign.ProductClient;
import com.tcs.aggregator.feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AggregatorController
{
    @Autowired
     ProductClient productClient;

    @Autowired
     OrderClient orderClient;

    @Autowired
    UserClient userClient;

    @GetMapping("/aggregator/{userId}/{id}")
    public ResponseEntity<Aggregator> aggregator(@PathVariable Long id, @PathVariable Long userId)
    {
        List<Order> orders=this.orderClient.getOrderByProduct(id).getBody();
        Product product=this.productClient.getProduct(id).getBody();
        Users user=this.userClient.getUser(userId).getBody();

        return ResponseEntity.ok(new Aggregator(product,orders,user));
    }
}
