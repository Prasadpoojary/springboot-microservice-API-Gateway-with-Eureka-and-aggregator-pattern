package com.tcs.aggregator.dto;


import lombok.Data;

@Data
public class Order
{
    private Long id;


    private String user;

    private Long product;

    private int quantity;
}
