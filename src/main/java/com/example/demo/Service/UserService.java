package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Entite.User;
import com.example.demo.Repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;

    public User creer(User user){
        return userRepository.save(user);
    }
}
