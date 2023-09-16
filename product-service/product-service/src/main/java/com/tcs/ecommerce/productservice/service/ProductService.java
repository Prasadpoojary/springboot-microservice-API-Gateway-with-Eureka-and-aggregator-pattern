package com.tcs.ecommerce.productservice.service;


import com.tcs.ecommerce.productservice.model.Product;
import com.tcs.ecommerce.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository productRepository;

    public Product add(Product product)
    {
        return this.productRepository.save(product);
    }

    public void delete(Long id)
    {
        this.productRepository.deleteById(id);
    }

    public List<Product> all()
    {
        return this.productRepository.findAll();
    }

    public Product get(Long id)
    {
        return this.productRepository.findById(id).get();
    }

    public Product update(Long id,Product product)
    {
        if(!this.productRepository.existsById(id))
        {
            return null;
        }
        return this.productRepository.save(product);
    }

}
