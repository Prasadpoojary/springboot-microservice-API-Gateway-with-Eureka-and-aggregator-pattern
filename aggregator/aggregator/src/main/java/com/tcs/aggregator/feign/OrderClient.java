package com.tcs.aggregator.feign;

import com.tcs.aggregator.dto.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value="order-service",url="http://127.0.0.1:8099/ORDER-SERVICE/")
public interface OrderClient
{
    @GetMapping("/order/product/{id}")
    ResponseEntity<List<Order>> getOrderByProduct(@PathVariable Long id);
}
