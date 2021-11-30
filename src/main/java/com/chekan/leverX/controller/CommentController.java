package com.chekan.leverX.controller;

import com.chekan.leverX.entity.Comment;
import com.chekan.leverX.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/articles/{id}/comments")
    public Comment addNewComment(@RequestBody Comment comment, @PathVariable int id) {
        comment.setCreatedAt(new Date(System.currentTimeMillis()));
        comment.setPostId(id);
        comment.setApproved(false);
        commentService.saveComment(comment);
        return comment;
    }

    @GetMapping("/users/{id}/comments")
    public List<Comment> showComments(@PathVariable int id){
        return commentService.getComments(id);
    }

    @GetMapping("/users/comments/{id}")
    public Comment showComment(@PathVariable int id){
        return commentService.getComment(id);
    }

    @PutMapping("/articles/{id}/comments")
    public Comment updateComment(@RequestBody Comment comment, @PathVariable int id){
        comment.setId(id);
        commentService.saveComment(comment);
        return comment;
    }

//    @PutMapping("/articles/{id}/comment/{rate}")
//    public String updateComment(@PathVariable int id, @PathVariable int rate){
//        Comment comment = commentService.getComment(id);
//        if(comment == null){
//            return "There is no comment with ID = " + id + " in Database";
//        }else {
//            commentService.updateComment(id, rate);
//            return "Comment with ID = " + id + " was deleted.";
//        }
//    }

}
