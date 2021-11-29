package com.chekan.leverX.dao;

import com.chekan.leverX.entity.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GameDAOImpl implements GameDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Game> getAllGames() {
        Session session = sessionFactory.getCurrentSession();
        List<Game> allGames = session.createQuery("from Game", Game.class).getResultList();
        return allGames;
    }

    @Override
    public void saveGame(Game game) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(game);
    }

}
