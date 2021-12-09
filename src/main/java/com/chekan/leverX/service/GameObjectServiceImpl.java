package com.chekan.leverX.service;

import com.chekan.leverX.dao.GameObjectDAO;
import com.chekan.leverX.entity.GameObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameObjectServiceImpl implements GameObjectService{

    @Autowired
    private GameObjectDAO gameObjectDAO;

    @Transactional
    @Override
    public void saveGameObject(GameObject gameObject) {
        gameObjectDAO.saveGameObject(gameObject);
    }

    @Transactional
    @Override
    public List<GameObject> getAllGameObjects() {
        return gameObjectDAO.getAllGameObjects();
    }

    @Transactional
    @Override
    public void deleteGameObject(int id) {
        gameObjectDAO.deleteGameObject(id);
    }

    @Transactional
    @Override
    public GameObject getGameObject(int id) {
        return gameObjectDAO.getGameObject(id);
    }

    @Transactional
    @Override
    public List<GameObject> getAllGameObjectsById(int id) {
        return gameObjectDAO.getAllGameObjectsById(id);
    }


}
