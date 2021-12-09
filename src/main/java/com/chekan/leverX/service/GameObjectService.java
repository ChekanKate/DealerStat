package com.chekan.leverX.service;

import com.chekan.leverX.entity.GameObject;
import java.util.List;

public interface GameObjectService {
    public void saveGameObject(GameObject gameObject);
    public List<GameObject> getAllGameObjects();
    public void deleteGameObject(int id);
    public GameObject getGameObject(int id);
    public List<GameObject> getAllGameObjectsById(int id);
}
