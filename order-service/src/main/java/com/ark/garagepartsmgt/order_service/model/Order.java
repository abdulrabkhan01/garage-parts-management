package com.ark.garagepartsmgt.order_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long partId;
    private long quantity;
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private Supplier supplier;
    private String status;
}