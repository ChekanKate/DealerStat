package com.chekan.leverX.controller;

import com.chekan.leverX.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CommentController2 {

    @Autowired
    private CommentService commentService;

    @GetMapping ("/post/{id}/comments")
    public String showComments(@PathVariable int id, Model model) {
        model.addAttribute("comments", commentService.getComments(id));
        return "listOfComments";
    }

}
