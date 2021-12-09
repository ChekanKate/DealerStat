package com.chekan.leverX.dao;

import com.chekan.leverX.entity.GameObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GameObjectDAOImpl implements GameObjectDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveGameObject(GameObject gameObject) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(gameObject);
    }

    @Override
    public List<GameObject> getAllGameObjects() {
        Session session = sessionFactory.getCurrentSession();
        List<GameObject> allGameObjects = session.createQuery("from GameObject", GameObject.class).getResultList();
        return allGameObjects;
    }

    @Override
    public void deleteGameObject(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<GameObject> query = session.createQuery("delete from GameObject where id=:gameObjectId");
        query.setParameter("gameObjectId", id);
        query.executeUpdate();
    }

    @Override
    public GameObject getGameObject(int id) {
        Session session = sessionFactory.getCurrentSession();
        GameObject gameObject = session.get(GameObject.class, id);
        return gameObject;
    }

    @Override
    public List<GameObject> getAllGameObjectsById(int id) {
        Session session = sessionFactory.getCurrentSession();
        List<GameObject> allGameObjects = session.createQuery("from GameObject where user_id=:userId", GameObject.class).setParameter("userId", id).getResultList();
        return allGameObjects;
    }

}
