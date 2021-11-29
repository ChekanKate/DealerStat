package com.chekan.leverX.service;

import com.chekan.leverX.dao.GameDAO;
import com.chekan.leverX.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameServiceImpl implements GameService{

    @Autowired
    private GameDAO gameDAO;

    @Override
    @Transactional
    public List<Game> getAllGames() {
        return gameDAO.getAllGames();
    }

    @Override
    @Transactional
    public void saveGame(Game game) {
        gameDAO.saveGame(game);
    }
}
