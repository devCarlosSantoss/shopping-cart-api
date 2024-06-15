package com.devcarlossantos.shoppingcartapi.repositories;

import com.devcarlossantos.shoppingcartapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
