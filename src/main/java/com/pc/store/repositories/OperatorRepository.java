package com.pc.store.repositories;

import com.pc.store.entities.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperatorRepository extends JpaRepository<Operator, Integer> {
    List<Operator> findByFirstName(String firstName);
    List<Operator> findByLastName(String lastName);
    List<Operator> findByCode(String code);

}
