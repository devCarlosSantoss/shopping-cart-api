package com.devcarlossantos.shoppingcartapi.config;

import com.devcarlossantos.shoppingcartapi.entities.Order;
import com.devcarlossantos.shoppingcartapi.entities.User;
import com.devcarlossantos.shoppingcartapi.entities.enums.OrderStatus;
import com.devcarlossantos.shoppingcartapi.repositories.OrderRepository;
import com.devcarlossantos.shoppingcartapi.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public TestConfig(final UserRepository userRepository, final OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Maria Brown", "maria@gmail.com", "71999249874", "123456");
        User user2 = new User(null, "Alex Green", "alexgreen@gmail.com", "71991235863", "123456");

        Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.SHIPPED, user1);
        Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.DELIVERED, user2);
        Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, user1);
        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }
}
