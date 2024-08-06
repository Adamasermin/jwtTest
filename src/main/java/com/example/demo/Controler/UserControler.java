package com.example.demo.Controler;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entite.User;
import com.example.demo.Service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserControler {
    
    private final UserService userService;

    @PostMapping("/creer")
    public User create(@RequestBody User user){
        return userService.creer(user);
    }
}
