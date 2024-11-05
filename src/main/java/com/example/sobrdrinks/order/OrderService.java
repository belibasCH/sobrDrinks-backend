package com.example.sobrdrinks.order;

import com.example.sobrdrinks.product.Product;
import com.example.sobrdrinks.user.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order orderNewDrink(User user, Product product) {
        Order order = new Order();
        order.setUser(user);
        order.setProduct(product);
        order.setStatus("PENDING");
        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);
    }

}
