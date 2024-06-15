package com.devcarlossantos.shoppingcartapi.resources;

import com.devcarlossantos.shoppingcartapi.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
    @GetMapping
    public ResponseEntity<User> findAll(){
        User user = new User(1L, "Carlos", "carlos@gmail.com", "71999249874", "carlos007");
        return ResponseEntity.ok().body(user);
    }
}
