package com.example.sobrdrinks.order;

import com.example.sobrdrinks.product.Product;
import com.example.sobrdrinks.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="\"order\"")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String status;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private LocalDateTime orderDate;


}
