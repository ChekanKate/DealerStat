package com.chekan.leverX.controller;

import com.chekan.leverX.entity.User;
import com.chekan.leverX.service.EmailService;
import com.chekan.leverX.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        return "main";
    }

    @RequestMapping("/registration")
    public String registerUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        } else {
            user.setRole("trader");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.saveUser(user);
            return "redirect:/";
        }
    }

    @RequestMapping("/sendEmail")
    public void sendEmail(){
        emailService.sendMail("5691016@stud.nau.edu.ua");
    }

}
