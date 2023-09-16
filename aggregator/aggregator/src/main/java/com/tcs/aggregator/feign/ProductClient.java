package com.tcs.aggregator.feign;

import com.tcs.aggregator.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="product-service",url = "http://127.0.0.1:8099/PRODUCT-SERVICE/")
public interface ProductClient
{
    @GetMapping("/product/{id}")
    ResponseEntity<Product> getProduct(@PathVariable Long id);
}
