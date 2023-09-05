package com.bookeasy.service;

import com.bookeasy.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll();

//    Order findById(int theOrderId);

    void save(Order theOrder);

    void deleteById(int theOrderId);

//    Order findById(int theOrderId);
}
