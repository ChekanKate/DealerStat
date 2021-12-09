package com.chekan.leverX.service;

import com.chekan.leverX.entity.Game;

import java.util.List;

public interface GameService {
    public List<Game> getAllGames();
    public Game getGameById(int id);
    public void saveGame(Game game);
}
