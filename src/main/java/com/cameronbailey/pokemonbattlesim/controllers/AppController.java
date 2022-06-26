package com.cameronbailey.pokemonbattlesim.controllers;

import com.cameronbailey.pokemonbattlesim.models.User;
import com.cameronbailey.pokemonbattlesim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class AppController {

    @Autowired
    private UserRepository repo;

    @GetMapping("")
    public String viewHomepage() {
        return "home";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        repo.save(user);

        return "register_success";
    }
}
