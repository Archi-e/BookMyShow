package com.archie.BookMyShow.service;

import com.archie.BookMyShow.model.User;
import com.archie.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User login(String email, String password) throws Exception {
        User savedUser = userRepository.findByEmail(email);
        if(savedUser == null){
            throw new Exception("Email Address incorrect!");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(password, savedUser.getPassword())){
            return savedUser;
        }
        throw new Exception("Wrong Password, Please enter correct password");
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public User signUp(String name, String email, String password) throws Exception {
        User savedUser = userRepository.findByEmail(email);
        if(savedUser != null){
            throw new Exception("User already exist!");
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));
        user.setTickets(new ArrayList<>());
        userRepository.save(user);
        return user;
    }
}
