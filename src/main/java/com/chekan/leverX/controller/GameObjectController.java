package com.chekan.leverX.controller;

import com.chekan.leverX.entity.GameObject;
import com.chekan.leverX.service.GameObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class GameObjectController {

    @Autowired
    private GameObjectService gameObjectService;

    @PostMapping("/object")
    public GameObject addNewGameObject(@RequestBody GameObject gameObject) {
        gameObject.setCreatedAt(new Date(System.currentTimeMillis()));
        gameObject.setUpdatedAt(new Date(System.currentTimeMillis()));
        gameObject.setApproved(false);
        gameObjectService.saveGameObject(gameObject);
        return gameObject;
    }

    @GetMapping("/object")
    public List<GameObject> showAllGameObjects() {
        List<GameObject> allGameObjects = gameObjectService.getAllGameObjects();
        return allGameObjects;
    }


    @DeleteMapping("/object/{id}")
    public String deleteGameObject(@PathVariable int id){
        GameObject gameObject = gameObjectService.getGameObject(id);
        if(gameObject == null){
            return "There is no employee with ID = " + id + " in Database";
        }else {
            gameObjectService.deleteGameObject(id);
            return "Employee with ID = " + id + " was deleted.";
        }
    }

    @PutMapping("/object")
    public GameObject updateGameObject(@RequestBody GameObject gameObject){
        gameObjectService.saveGameObject(gameObject);
        return gameObject;
    }

}
