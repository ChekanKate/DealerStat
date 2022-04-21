package com.chekan.leverX.controller;

import com.chekan.leverX.entity.User;
import com.chekan.leverX.service.EmailService;
import com.chekan.leverX.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    @RequestMapping("/")
    public String mainView() {
        return "home";
    }

    @GetMapping("/user/signUp")
    public String showSignUp(User user) {
        return "signUp";
    }

    @PostMapping("/user/add")
    public String addNewUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "signUp";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        String code = emailService.sendMail(user.getEmail());
        user.setActivationCode(code);
        userService.saveUser(user);
        return "redirect:/";
    }

}
