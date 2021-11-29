package com.chekan.leverX.controller;

import com.chekan.leverX.entity.Game;
import com.chekan.leverX.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/games")
    public List<Game> showAllGames(){
        List<Game> allGames = gameService.getAllGames();
        return allGames;
    }

    @PostMapping("/games")
    public Game addNewGame(@RequestBody Game game) {
        gameService.saveGame(game);
        return game;
    }

    @PutMapping("/games")
    public Game updateEmployee(@RequestBody Game game){
        gameService.saveGame(game);
        return game;
    }


}
