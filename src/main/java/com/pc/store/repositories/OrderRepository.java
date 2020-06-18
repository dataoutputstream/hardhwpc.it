package com.pc.store.repositories;

import com.pc.store.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order>findOrderById(Integer id);
    List<Order>findOrderByDate(Date d);
    List<Order>findOrderByUser(Integer id);
}
