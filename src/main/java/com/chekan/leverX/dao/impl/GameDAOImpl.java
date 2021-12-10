package com.chekan.leverX.dao.impl;

import com.chekan.leverX.dao.GameDAO;
import com.chekan.leverX.entity.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GameDAOImpl implements GameDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Game> getAllGames() {
        Session session = sessionFactory.getCurrentSession();
        List<Game> allGames = session.createQuery("from Game", Game.class).getResultList();
        return allGames;
    }

    @Override
    public Game getGameById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Game> query = session.createQuery("from Game where id=:id", Game.class);
        query.setParameter("id", id);
        Game game = query.getSingleResult();
        return game;
    }

    @Override
    public void saveGame(Game game) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(game);
    }

}
