package com.devcarlossantos.shoppingcartapi.repositories;

import com.devcarlossantos.shoppingcartapi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
