package com.hardhw.pc.services;


import com.hardhw.pc.entities.Order;
import com.hardhw.pc.entities.Product;
import com.hardhw.pc.entities.User;
import com.hardhw.pc.repositories.OrderRepository;
import com.hardhw.pc.repositories.UserRepository;
import com.hardhw.pc.support.exceptions.DateWrongRangeException;
import com.hardhw.pc.support.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

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

    @Transactional(readOnly = true)
    public List<Order> getPurchasesByUserInPeriod(User user, Date startDate, Date endDate) throws UserNotFoundException, DateWrongRangeException {
        if ( !userRepository.existsById(user.getId()) ) {
            throw new UserNotFoundException();
        }
        if ( startDate.compareTo(endDate) >= 0 ) {
            throw new DateWrongRangeException();
        }
        return orderRepository.findByBuyerInPeriod(startDate, endDate, user);
    }


}
