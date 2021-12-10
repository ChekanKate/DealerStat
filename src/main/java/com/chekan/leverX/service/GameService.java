package com.chekan.leverX.service;

import com.chekan.leverX.entity.Game;

import java.util.List;

public interface GameService {

    List<Game> getAllGames();

    Game getGameById(int id);

    void saveGame(Game game);

}
