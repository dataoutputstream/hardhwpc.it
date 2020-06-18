package com.hardhw.pc.services;

import com.hardhw.pc.entities.User;
import com.hardhw.pc.repositories.UserRepository;
import com.hardhw.pc.support.exceptions.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserUtilsService {
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public void delete(User u){
        userRepository.delete(u);
    }
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void registerUser(User user) throws UserAlreadyExistException {
        if ( userRepository.existsByEmail(user.getEmail()) ) {
            throw new UserAlreadyExistException();
        }
        userRepository.save(user);
    }

}
