package com.pc.store.services;

import com.pc.store.entities.Order;
import com.pc.store.entities.Product;
import com.pc.store.entities.User;
import com.pc.store.repositories.OrderRepository;
import com.pc.store.repositories.UserRepository;
import com.pc.store.support.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EntityManager entityManager;

    @Transactional(readOnly = false)
    public Order addOrder(Order order) {
        Order result = orderRepository.save(order);
        for (Product product : result.getproductsInOrder() ) {
            product.setOrders(result);
            entityManager.refresh(product);
        }
        entityManager.refresh(result);
        return result;
    }
    @Transactional(readOnly = true)
    public List<Order> getOrderByUser(User user) throws UserNotFoundException {
        if ( !userRepository.existsById(user.getId()) ) {
            throw new UserNotFoundException();
        }
        return orderRepository.findOrderByUser(user.getId());
    }


}
