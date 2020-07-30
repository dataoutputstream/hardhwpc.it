package com.hardhwpc.backend.repositories;


import com.hardhwpc.backend.entities.Order;
import com.hardhwpc.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, BigInteger> {
    List<Order>findOrderById(Integer id);
    //List<Order>findOrderByDate(Date purchase_time);
    List<Order>findOrderBybuyer(User u);
    List<Order>findOrderByOrdernumber(String ordernumber);
    Order findByShippingnumber(String shippingnumber);
    List<Order>findOrdersByShippingnumberContaining(String shippingnumber);
    List<Order> findOrdersByOrdernumberContaining(String orderNumber);
    void deleteOrderById(BigInteger id);
    //List<Order> findByBuyerAndPurchaseTime(Date startDate, Date endDate, User user);
}
