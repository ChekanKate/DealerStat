package com.chekan.leverX.controller;

import com.chekan.leverX.entity.Comment;
import com.chekan.leverX.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private CommentService commentService;

//    @GetMapping("/object/{id}")
//    public String showRatingOfGameObject(@PathVariable int id, Model model){
//        List<Comment> comments = commentService.getComments(id);
//        List<Integer> rates = new ArrayList<>();
//        for(Comment comment : comments){
//            rates.add(comment.getRate());
//        }
//        double sum = 0;
//        for(Integer integer : rates) {
//            sum += integer;
//        }
//        String average = "Average rating of this game object : " + sum/rates.size();
//        String number = "   Number of comments : " + rates.size();
//        return average + number;
//    }

    @GetMapping("/object/{id}")
    public String showRatingOfGameObject(@PathVariable int id, Model model){
        List<Comment> comments = commentService.getComments(id);
        List<Integer> rates = new ArrayList<>();
        for(Comment comment : comments){
            rates.add(comment.getRate());
        }
        double sum = 0;
        for(Integer integer : rates) {
            sum += integer;
        }
        String average = "Average rating of this game object : " + sum/rates.size() + " ";
        String number = " Number of comments : " + rates.size();
        String result = average + number;
        model.addAttribute("result", result);
        return "ratingGameObject";
    }

}
