package com.devcarlossantos.shoppingcartapi.config;

import com.devcarlossantos.shoppingcartapi.entities.User;
import com.devcarlossantos.shoppingcartapi.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;

    public TestConfig(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Maria Brown", "maria@gmail.com", "71999249874", "123456");
        User user2 = new User(null, "Alex Green", "alexgreen@gmail.com", "71991235863", "123456");

        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}
