package com.hardhwpc.backend.services;


import com.hardhwpc.backend.entities.Order;
import com.hardhwpc.backend.entities.Product;
import com.hardhwpc.backend.entities.User;
import com.hardhwpc.backend.repositories.OrderRepository;
import com.hardhwpc.backend.repositories.UserRepository;
import com.hardhwpc.backend.support.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {


    @Autowired()
    private UserRepository userRepository;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional(readOnly = false)
    public Order addOrder(Order order) {
        Order result = orderRepository.save(order);
        return result;
    }

    @Transactional(readOnly = false)
    public  void removeOrder(Order order){
        orderRepository.delete(order);
    }

    @Transactional(readOnly = true)
    public List<Order> getOrderByUser(User user) throws UserNotFoundException {
        if ( !userRepository.existsById(user.getId()) ) {
            throw new UserNotFoundException();
        }
        return orderRepository.findOrderBybuyer(user);
    }

    @Transactional(readOnly = true)
    public List<Order> showAllOrders(int pageNumber, int pageSize, String sortBy, String type) {
        Pageable paging;
        if(type.equalsIgnoreCase("ascending")) {
            paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
        }else paging = PageRequest.of(pageNumber,pageSize,Sort.by(sortBy).descending());
        Page<Order> pagedResult = orderRepository.findAll(paging);
        if ( pagedResult.hasContent() ) {
            return pagedResult.getContent();
        }
        else {
            return new ArrayList<>();
        }
    }

    public List<Order> showOrderByOrderNumber(String orderNumber) {
        List<Order> ordini= new ArrayList<>();
       ordini=orderRepository.findOrdersByOrdernumberContaining(orderNumber);
       return ordini;
    }

    public List<Order> showOrdersByShippingNumber(String value) {
        List<Order> ordini= new ArrayList<>();
        ordini=orderRepository.findOrdersByShippingnumberContaining(value);
        return ordini;
    }
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void removeOrder(BigInteger id) {
        orderRepository.deleteOrderById(id);
    }


/**
    @Transactional(readOnly = true)
    public List<Order> getPurchasesByUserInPeriod(User user, Date startDate, Date endDate) throws UserNotFoundException, DateWrongRangeException {
        if ( !userRepository.existsById(user.getId()) ) {
            throw new UserNotFoundException();
        }
        if ( startDate.compareTo(endDate) >= 0 ) {
            throw new DateWrongRangeException();
        }
        return orderRepository.findByBuyerAndPurchaseTime(startDate, endDate, user);
    }
**/

}
