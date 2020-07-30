package com.hardhwpc.backend.repositories;


import com.hardhwpc.backend.entities.Order;
import com.hardhwpc.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, BigInteger> {
    User findUsersById (BigInteger id);
    List<User> findUsersByFirstNameContainingOrLastNameContaining(String firstname,String lastname);
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
    User findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByFirstNameOrLastName(String first_name,String name_lastame);
    List<User> findByEmailContainingIgnoreCase(String email);
    List<Order> findOrderById(BigInteger id);
}
