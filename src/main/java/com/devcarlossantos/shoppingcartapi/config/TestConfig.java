package com.devcarlossantos.shoppingcartapi.config;

import com.devcarlossantos.shoppingcartapi.entities.Category;
import com.devcarlossantos.shoppingcartapi.entities.Order;
import com.devcarlossantos.shoppingcartapi.entities.Product;
import com.devcarlossantos.shoppingcartapi.entities.User;
import com.devcarlossantos.shoppingcartapi.entities.enums.OrderStatus;
import com.devcarlossantos.shoppingcartapi.repositories.CategoryRepository;
import com.devcarlossantos.shoppingcartapi.repositories.OrderRepository;
import com.devcarlossantos.shoppingcartapi.repositories.ProductRepository;
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
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public TestConfig(final UserRepository userRepository, final OrderRepository orderRepository, final CategoryRepository categoryRepository, final ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {

        // Criação de usuários para teste
        User user1 = new User(null, "Maria Brown", "maria@gmail.com", "71999249874", "123456");
        User user2 = new User(null, "Alex Green", "alexgreen@gmail.com", "71991235863", "123456");

        // Criação de pedidos para teste
        Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.SHIPPED, user1);
        Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.DELIVERED, user2);
        Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, user1);

        // Criação de categorias para teste
        Category category1 = new Category(null, "Eletronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");

        // Criação dos produtos para teste
        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }
}
