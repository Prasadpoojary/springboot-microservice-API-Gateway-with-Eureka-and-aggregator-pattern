package com.tcs.aggregator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aggregator
{
    private Product product;
    private List<Order> orderList;
    private Users users;
}
