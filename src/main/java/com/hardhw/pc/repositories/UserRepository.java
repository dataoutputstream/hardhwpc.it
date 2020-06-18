package com.hardhw.pc.repositories;


import com.hardhw.pc.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findUsersById (Integer id);
    List<User> findUsersByFirstNameContainingOrLastNameContaining(String firstname,String lastname);
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
    List<User> findByEmail(String email);
    List<User> findByCode(String code);
    boolean existsByEmail(String email);
    boolean existsByFirstNameOrLastName(String name_lastame);

}
