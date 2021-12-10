package com.chekan.leverX.controller;

import com.chekan.leverX.entity.NewPassword;
import com.chekan.leverX.entity.Role;
import com.chekan.leverX.entity.User;
import com.chekan.leverX.service.EmailService;
import com.chekan.leverX.service.RoleService;
import com.chekan.leverX.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class ActivationController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/activate/{email}/{code}")
    public String activateAccount(@PathVariable String email, @PathVariable String code){
        User user = userService.getByUserEmail(email);
        if(code.equals(user.getActivationCode())){
            Role role = roleService.getRoleByName("ROLE_TRADER");
            user.getRoles().add(role);
            userService.saveUser(user);
            return "Account activation was successful";
        } else {
            return "Wrong activation code, please try again";
        }
    }

    @GetMapping("/auth/forgot_password/{email}")
    public String forgotPassword(@PathVariable String email){
        User user = userService.getByUserEmail(email);
        if(user == null){
            return "User with this email does not exist.";
        } else {
            String code = emailService.sendMail(email);
            user.setActivationCode(code);
            userService.saveUser(user);
            return "Check your email.";
        }
    }

    @PostMapping("/auth/reset")
    public String resetPassword(@RequestBody NewPassword newPassword){
        User user = userService.getUserByActivationCode(newPassword.getCode());
        if(user == null){
            return "Wrong activation code!";
        } else {
            user.setPassword(passwordEncoder.encode(newPassword.getPassword()));
            userService.saveUser(user);
            return "Password changed successfully.";
        }
    }

}
