package com.chekan.leverX.dao;

import com.chekan.leverX.entity.Game;
import java.util.List;

public interface GameDAO {
    public List<Game> getAllGames();
    public void saveGame(Game game);

}
