package com.chekan.leverX.dao;

import com.chekan.leverX.entity.Game;

import java.util.List;

public interface GameDAO {

    List<Game> getAllGames();

    Game getGameById(int id);

    void saveGame(Game game);

}
