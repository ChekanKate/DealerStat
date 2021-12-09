package com.chekan.leverX.controller;

import com.chekan.leverX.entity.Comment;
import com.chekan.leverX.entity.Game;
import com.chekan.leverX.entity.GameObject;
import com.chekan.leverX.service.CommentService;
import com.chekan.leverX.service.GameObjectService;
import com.chekan.leverX.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private CommentService commentService;


    @GetMapping("/object/{id}")
    public String showRatingOfGameObject(@PathVariable int id){
        List<Comment> comments = commentService.getComments(id);
        List<Integer> rates = new ArrayList<>();
        for(Comment comment : comments){
            rates.add(comment.getRate());
        }
        double sum = 0;
        for(Integer integer : rates) {
            sum += integer;
        }
        String average = "Average rating of this game object : " + sum/rates.size();
        String number = "   Number of comments : " + rates.size();
        return average + number;
    }

}
