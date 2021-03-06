package com.dzr.controller;


import com.dzr.repository.AdminRepository;
import com.dzr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username")String username,@PathVariable("password")String password,@PathVariable("type")String type){
        Object object = null;
        switch (type){
                case "user":
                    object = userRepository.login(username, password);
                    break;
                case "admin":
                    object = adminRepository.login(username, password);
                    break;
            }
            return  object;
    }

}
