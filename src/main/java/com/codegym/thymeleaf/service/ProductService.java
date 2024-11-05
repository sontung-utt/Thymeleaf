package com.codegym.thymeleaf.service;

import com.codegym.thymeleaf.model.Customer;
import com.codegym.thymeleaf.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IService<Product>{
    List<Product> products = new ArrayList<>();
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void remove(int id) {

    }
}
