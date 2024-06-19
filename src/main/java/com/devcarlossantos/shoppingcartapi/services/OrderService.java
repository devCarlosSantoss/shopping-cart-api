package com.devcarlossantos.shoppingcartapi.services;

import com.devcarlossantos.shoppingcartapi.entities.Order;
import com.devcarlossantos.shoppingcartapi.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> order =  orderRepository.findById(id);
        return order.get();
    }
}
