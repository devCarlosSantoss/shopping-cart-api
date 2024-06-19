package com.devcarlossantos.shoppingcartapi.repositories;

import com.devcarlossantos.shoppingcartapi.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
