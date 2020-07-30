package com.hardhwpc.backend.repositories;

import com.hardhwpc.backend.entities.BillingData;
import com.hardhwpc.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface BillingRepository extends JpaRepository<BillingData, Integer> {
    public  boolean existsById(BigInteger id);
    BillingData findBillingDataByUser(User user);
}
