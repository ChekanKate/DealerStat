package com.chekan.leverX.controller;

import com.chekan.leverX.entity.Game;
import com.chekan.leverX.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/games/")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("signUp")
    public String showSignUp(Game game) {
        return "addGame";
    }

    @GetMapping("/list")
    public String showAllGames(Model model) {
        model.addAttribute("games", gameService.getAllGames());
        return "listOfGames";
    }

    @PostMapping("/add")
    public String addNewGame(@Valid Game game, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addGame";
        }
        gameService.saveGame(game);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Game game = gameService.getGameById(id);
        model.addAttribute("game", game);
        return "updateGame";
    }

    @PostMapping("update/{id}")
    public String updateGame(@PathVariable("id") int id, @Valid Game game, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            game.setId(id);
            return "updateGame";
        }

        gameService.saveGame(game);
        model.addAttribute("games", gameService.getAllGames());
        return "listOfGames";
    }
}
