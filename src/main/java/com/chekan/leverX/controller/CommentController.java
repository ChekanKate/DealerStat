package com.chekan.leverX.controller;

import com.chekan.leverX.entity.Comment;
import com.chekan.leverX.exceptions.MyNoSuchElementException;
import com.chekan.leverX.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<Comment> showApprovedComments(@PathVariable int id){
        List<Comment> allComments = commentService.getComments(id);
        List<Comment> approvedComments = new ArrayList<>();
        for(Comment comment : allComments){
            if(comment.isApproved() == true){
                approvedComments.add(comment);
            }
        }
        if(approvedComments.isEmpty()){
            throw new MyNoSuchElementException("There is no approved comments that belong to the post with id " + id + " in Database");
        }
        return approvedComments;
    }

    @GetMapping("/admin/users/{id}/comments")
    public List<Comment> showComments(@PathVariable int id){
        List<Comment> comments = commentService.getComments(id);
        if(comments.isEmpty()){
            throw new MyNoSuchElementException("There is no comments that belong to the post with id " + id + " in Database");
        }
        return comments;
    }

    @GetMapping("/users/comments/{id}")
    public Comment showComment(@PathVariable int id){
        Comment comment = commentService.getComment(id);
        if (comment == null){
            throw new MyNoSuchElementException("There is no comment with ID = " + id + " in Database");
        }
        return comment;
    }

    @DeleteMapping("/comments/{id}")
    public String deleteComment(@PathVariable int id){
        Comment comment = commentService.getComment(id);
        if(comment == null){
            return "There is no comment with ID = " + id + " in Database";
        } else {
            commentService.deleteComment(id);
            return "Comment with ID = " + id + " was deleted.";
        }
    }

    @PutMapping("/articles/{id}/comments")
    public Comment updateComment(@RequestBody Comment comment, @PathVariable int id){
        Comment comment1 = commentService.getComment(id);
        if (comment1 == null){
            throw new MyNoSuchElementException("There is no comment with ID = " + id + " in Database");
        }
        comment1.setApproved(false);
        comment1.setMessage(comment.getMessage());
        comment1.setRate(comment.getRate());
        return comment1;
    }

    @PutMapping("/comment/approve/{id}")
    public Comment approveComment(@PathVariable int id){
        Comment comment = commentService.getComment(id);
        if (comment == null){
            throw new MyNoSuchElementException("There is no comment with ID = " + id + " in Database");
        }
        comment.setApproved(true);
        commentService.saveComment(comment);
        return comment;
    }

}
