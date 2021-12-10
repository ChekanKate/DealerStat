package com.chekan.leverX.service;

import com.chekan.leverX.entity.GameObject;

import java.util.List;

public interface GameObjectService {

    void saveGameObject(GameObject gameObject);

    List<GameObject> getAllGameObjects();

    void deleteGameObject(int id);

    GameObject getGameObject(int id);

    List<GameObject> getAllGameObjectsByUserId(int id);

}
