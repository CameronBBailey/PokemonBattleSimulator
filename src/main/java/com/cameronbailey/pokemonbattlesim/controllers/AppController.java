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
    private UserRepository repo; /* Create an instance of our User Repository */

    @GetMapping("")
    public String viewHomepage() {
        return "home";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User()); /* Adds a User attribute to our model to store our registration info*/

        return "register";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); /* Encodes our password to store it safely in our database */
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);/* sets the password on the user object to our enocoded password */
        try {
            repo.save(user); /* Saves our user to the database */
        } catch (Exception e) {
            return "redirect:/register";
        }

        return "register_success";
    }
}
