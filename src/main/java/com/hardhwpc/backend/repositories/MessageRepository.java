package com.hardhwpc.backend.repositories;

import com.hardhwpc.backend.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
@Repository
public interface MessageRepository extends JpaRepository<Message, BigInteger> {
    List<Message> findMessagesByEmailContaining(String email);
    List<Message> findMessagesById(BigInteger id);
    List<Message> findMessagesByNameContainingIgnoreCase(String name);
}
