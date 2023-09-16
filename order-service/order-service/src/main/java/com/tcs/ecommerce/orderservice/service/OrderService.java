package com.tcs.ecommerce.orderservice.service;


import com.tcs.ecommerce.orderservice.model.Order;
import com.tcs.ecommerce.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class OrderService
{
    @Autowired
    private OrderRepository orderRepository;



    public Order add(Order order)
    {
        return this.orderRepository.save(order);
    }

    public void delete(Long id)
    {
        this.orderRepository.deleteById(id);
    }

    public List<Order> all()
    {
        return this.orderRepository.findAll();
    }

    public Order get(Long id)
    {
        return this.orderRepository.findById(id).get();
    }

    public List<Order> getOrderByProduct(Long id)
    {
        return this.orderRepository.findByProduct(id);
    }

    public Order update(Long id,Order order)
    {
        if(!this.orderRepository.existsById(id))
        {
            return null;
        }
        return this.orderRepository.save(order);
    }

}
