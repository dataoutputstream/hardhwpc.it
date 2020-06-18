package com.hardhw.pc.repositories;

import com.hardhw.pc.entities.Order;
import com.hardhw.pc.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order>findOrderById(Integer id);
    List<Order>findOrderByDate(Date d);
    List<Order>findOrderByUser(Integer id);
    List<Order> findByBuyerInPeriod(Date startDate, Date endDate, User user);
}
