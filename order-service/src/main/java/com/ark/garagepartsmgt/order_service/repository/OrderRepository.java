package com.ark.garagepartsmgt.order_service.repository;

import com.ark.garagepartsmgt.order_service.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}