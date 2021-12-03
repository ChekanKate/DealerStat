package com.chekan.leverX.controller;

import com.chekan.leverX.entity.Comment;
import com.chekan.leverX.entity.User;
import com.chekan.leverX.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivationController {

    @Autowired
    private UserService userService;

//    private UserService2 userService2;
//
//    @Autowired
//    public void setUserService(UserService2 userService2) {
//        this.userService2 = userService2;
//    }

    @GetMapping("/activate/{id}/{code}")
    public String activateAccount(@PathVariable int id, @PathVariable String code){
        User user = userService.getUser(id);
        if(code.equals(user.getActivationCode())){
            userService.saveUser(user);
            return "Account activation was successful";
        } else {
            return "Wrong activation code, please try again";
        }
    }

//    @GetMapping("/user/{email}")
//    public User showUser(@PathVariable String email){
//        return userService.getByUserEmail(email);
//    }

}
