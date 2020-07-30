package com.hardhwpc.backend.services;


import com.hardhwpc.backend.entities.User;
import com.hardhwpc.backend.repositories.UserRepository;
import com.hardhwpc.backend.support.exceptions.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserUtilsService {
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(User u){
        userRepository.delete(u);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public User registerUser(User user) throws UserAlreadyExistException {
        if ( userRepository.existsByEmail(user.getEmail()) ) {
            throw new UserAlreadyExistException();
        }
        userRepository.save(user);
        return user;
    }

    @Transactional(readOnly = false, propagation =Propagation.REQUIRED)
    public User updateUser(User user){
        return userRepository.saveAndFlush(user);
    }

    @Transactional(readOnly = true, propagation =Propagation.REQUIRED)
    public boolean containsUserByEmail(String user) {
        return userRepository.existsByEmail(user);
    }

    @Transactional(readOnly = true, propagation =Propagation.REQUIRED)
    public User getLogInIfDatasMatches(String user, String passwordencoded) {
        User u = userRepository.findByEmail(user);
        if(u.getPasswod()==null)return null;
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(bCryptPasswordEncoder.matches(u.getPasswod(),passwordencoded)){
            return u;
        }
        return null;
    }
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public User getUserByEmail(String email){
        User u = userRepository.findByEmail(email);
        return u;
    }
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<User> showAllUsers(int pageNumber, int pageSize, String sortBy, String type) {
        Pageable paging;
        if(type.equalsIgnoreCase("ascending")) {
            paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
        }else paging = PageRequest.of(pageNumber,pageSize,Sort.by(sortBy).descending());
        Page<User> pagedResult = userRepository.findAll(paging);
        if ( pagedResult.hasContent() ) {
            return pagedResult.getContent();
        }
        else {
            return new ArrayList<>();
        }
    }
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<User> getUsersByEmail(String email) {
        List<User> u = new ArrayList<>();
        u=userRepository.findByEmailContainingIgnoreCase(email);
        return u;
    }
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<User> getUsersByName(String value) {
        List<User> u = new ArrayList<>();
        u=userRepository.findByFirstName(value);
        return u;
    }
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public boolean checkPassword(User user) {
        User u = userRepository.findByEmail(user.getEmail());
        if(u.getPasswod()==null)return false;
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(bCryptPasswordEncoder.matches(u.getPasswod(),user.getPasswod())){
            return true;
        }
        return false;
    }
}
