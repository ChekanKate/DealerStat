package com.chekan.leverX.controller;

import com.chekan.leverX.entity.Comment;
import com.chekan.leverX.entity.Game;
import com.chekan.leverX.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CommentController2 {

    @Autowired
    private CommentService commentService;

    @GetMapping ("/post/{id}/comments")
    public String showComments(@PathVariable int id, Model model) {
        model.addAttribute("comments", commentService.getComments(id));
        return "listOfComments";
    }

    @GetMapping("/comment/signUp")
    public String showSignUp(Comment comment) {
        return "addComment";
    }

    @PostMapping("/comment/add")
    public String addNewComment(@Valid Comment comment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addComment";
        }
        commentService.saveComment(comment);
        return "redirect:list";
    }

}
