package com.pc.store.repositories;

import com.pc.store.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

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
