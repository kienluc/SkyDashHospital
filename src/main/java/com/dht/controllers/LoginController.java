package com.dht.controllers;

import com.dht.service.IAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private IAccountsService accountsService;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @RequestMapping()
    public String login() {
//        System.out.println(encoder.encode("123"));
        return "login";
    }
}
