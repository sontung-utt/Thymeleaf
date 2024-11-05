package com.codegym.thymeleaf.service;
import com.codegym.thymeleaf.model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Service
@Component
public class CustomerService implements IService<Customer> {
    private final List<Customer> customers;

    public CustomerService(){
        customers = new ArrayList<>();
        customers.add(new Customer(1,"Tùng","tung@gmail.com","Lê Trọng Tấn"));
        customers.add(new Customer(2,"Hải","tung@gmail.com","Lê Trọng Tấn"));
        customers.add(new Customer(3,"Đức","tung@gmail.com","Lê Trọng Tấn"));
        customers.add(new Customer(4,"Kiên","tung@gmail.com","Lê Trọng Tấn"));
        customers.add(new Customer(5,"Long","tung@gmail.com","Lê Trọng Tấn"));
    }

    @Override
    public void add(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void update(int id, Customer customer) {
        int index = findIndexById(id);
        customers.set(index,customer);
    }

    @Override
    public void remove(int id) {
        int index = findIndexById(id);
        customers.remove(index);
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer : customers){
            if (customer.getId()==id){
                return customer;
            }
        }
        return null;
    }

    public int findIndexById(int id) {
        for (int i = 0; i < customers.size(); i++){
            if (customers.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }
}
