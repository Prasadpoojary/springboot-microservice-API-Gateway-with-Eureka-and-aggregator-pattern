package com.tcs.aggregator.feign;

import com.tcs.aggregator.dto.Product;
import com.tcs.aggregator.dto.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="user-service",url = "http://127.0.0.1:8099/USER-SERVICE/")
public interface UserClient
{
    @GetMapping("/user/{id}")
    ResponseEntity<Users> getUser(@PathVariable Long id);
}
