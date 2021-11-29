package com.chekan.leverX.dao;

import com.chekan.leverX.entity.Game;
import com.chekan.leverX.entity.GameObject;

import java.util.List;

public interface GameObjectDAO {
    public void saveGameObject(GameObject gameObject);
    public List<GameObject> getAllGameObjects();
    public void deleteGameObject(int id);
    public GameObject getGameObject(int id);
}
