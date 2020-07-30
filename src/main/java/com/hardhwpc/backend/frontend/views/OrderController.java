package com.hardhwpc.backend.frontend.views;

import com.hardhwpc.backend.entities.BillingData;
import com.hardhwpc.backend.entities.Order;
import com.hardhwpc.backend.entities.User;
import com.hardhwpc.backend.services.BillingService;
import com.hardhwpc.backend.services.OrderService;
import com.hardhwpc.backend.services.ProductService;
import com.hardhwpc.backend.services.UserUtilsService;
import com.hardhwpc.backend.support.exceptions.ProductQuantityFault;
import com.hardhwpc.backend.support.exceptions.UserAlreadyExistException;


import javax.annotation.PostConstruct;
import java.util.List;

public class OrderController {
    OrderService orderService;
    UserUtilsService userUtilsService;
    BillingService billingService;
    ProductService productService;

    public OrderController() {
    }
    @PostConstruct
    public User registerUser(User bean) throws UserAlreadyExistException {
        return userUtilsService.registerUser(bean);
    }
    @PostConstruct
    public BillingData addBillingData(BillingData bean) {
        return billingService.addBillingData(bean);
    }

    @PostConstruct
    public Order addOrder(Order ordine)  {
        try {
            productService.updateQuantity(ordine.getProductsInOrder());
        } catch (ProductQuantityFault productQuantityFault) {
           return null;
        }
        return orderService.addOrder(ordine);

    }

    @PostConstruct
    public  BillingData getBillingDataForUser(User u){
        return billingService.getBillingDataForUser(u);
    }
    @PostConstruct
    public List<Order> fetchOrders(){
        return orderService.getAllOrders();
    }

    public void setServices(OrderService orderService, UserUtilsService userUtilsService, BillingService billingService,ProductService productService) {
        this.orderService=orderService;
        this.userUtilsService=userUtilsService;
        this.billingService=billingService;
        this.productService=productService;
    }
    @PostConstruct
    public void updateData(User bean) {
        userUtilsService.updateUser(bean);
    }

    @PostConstruct
    public User getUserByEmail(String value) {
        return userUtilsService.getUserByEmail(value);
    }
    @PostConstruct
    public User updateUser(User u) {
        return userUtilsService.updateUser(u);
    }
    @PostConstruct
    public boolean matchPassword(User user) {
        return userUtilsService.checkPassword(user);
    }
}
