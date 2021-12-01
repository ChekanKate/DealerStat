package com.chekan.leverX.controller;

import com.chekan.leverX.entity.User;
import com.chekan.leverX.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivationController {

    @Autowired
    private UserService userService;

    @PutMapping("/activate/{id}/{code}")
    public String activateAccount(@PathVariable int id, @PathVariable String code){
        User user = userService.getUser(id);
        if(code.equals(user.getActivationCode())){
            user.setRole("trader");
            userService.saveUser(user);
            return "Account activation was successful";
        } else {
            return "Wrong activation code, please try again";
        }
    }

}
