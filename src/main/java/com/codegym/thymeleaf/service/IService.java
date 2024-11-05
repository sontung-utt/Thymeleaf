package com.codegym.thymeleaf.service;

import com.codegym.thymeleaf.model.Customer;

import java.util.List;

public interface IService<E> {
    List<E> findAll();

    void add(E e);

    Customer findById(int id);

    void update(int id, E e);

    void remove(int id);
}
