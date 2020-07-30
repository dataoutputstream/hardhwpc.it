package com.hardhwpc.backend.services;

import com.hardhwpc.backend.entities.BillingData;
import com.hardhwpc.backend.entities.User;
import com.hardhwpc.backend.repositories.BillingRepository;
import com.hardhwpc.backend.support.exceptions.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BillingService {
    @Autowired
    BillingRepository billingRepository;
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public BillingData addBillingData(
            BillingData user) {
       return billingRepository.save(user);

    }
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public BillingData getBillingDataForUser(User u){
        return billingRepository.findBillingDataByUser(u);
    }
}
