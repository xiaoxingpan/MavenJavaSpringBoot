package com.bookeasy.service;

import com.bookeasy.dao.OrderRepository;
import com.bookeasy.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository theOrderRepository) { this.orderRepository = theOrderRepository;}

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void save(Order theOrder) {
         orderRepository.save(theOrder);
    }

    @Override
    public void deleteById(int theOrderId) {

    }


}
