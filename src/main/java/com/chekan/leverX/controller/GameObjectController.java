package com.chekan.leverX.controller;

import com.chekan.leverX.entity.GameObject;
import com.chekan.leverX.entity.User;
import com.chekan.leverX.service.GameObjectService;
import com.chekan.leverX.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class GameObjectController {

    @Autowired
    private GameObjectService gameObjectService;

    @Autowired
    private UserService userService;

    @PostMapping("/object")
    public GameObject addNewGameObject(@RequestBody GameObject gameObject) {
        gameObject.setCreatedAt(new Date(System.currentTimeMillis()));
        gameObject.setApproved(false);
        gameObjectService.saveGameObject(gameObject);
        return gameObject;
    }

    @GetMapping("/object")
    public List<GameObject> showApprovedGameObjects() {
        List<GameObject> allGameObjects = gameObjectService.getAllGameObjects();
        List<GameObject> approvedGameObjects = new ArrayList<>();
        for(GameObject object : allGameObjects){
            if(object.isApproved() == true){
                approvedGameObjects.add(object);
            }
        }
        return approvedGameObjects;
    }

    @GetMapping("/admin/object")
    public List<GameObject> showAllGameObjects() {
        List<GameObject> allGameObjects = gameObjectService.getAllGameObjects();
        return allGameObjects;
    }

    @DeleteMapping("/object/{id}")
    public String deleteGameObject(@PathVariable int id){
        GameObject gameObject = gameObjectService.getGameObject(id);
        if(gameObject == null){
            return "There is no game object with ID = " + id + " in Database";
        }else {
            gameObjectService.deleteGameObject(id);
            return "Game object with ID = " + id + " was deleted.";
        }
    }

    @PutMapping("/object/{id}")
    public GameObject updateGameObject(@RequestBody GameObject gameObject, @PathVariable int id){
        GameObject gameObject1 = gameObjectService.getGameObject(id);
        gameObject1.setApproved(false);
        gameObject1.setTitle(gameObject.getTitle());
        gameObject1.setText(gameObject.getText());
        gameObject1.setUpdatedAt(new Date(System.currentTimeMillis()));
        gameObjectService.saveGameObject(gameObject1);
        return gameObject1;
    }

    @GetMapping("/my")
    public List<GameObject> showAllMyGameObjects(Principal principal){
        User user = userService.getByUserEmail(principal.getName());
        return gameObjectService.getAllGameObjectsById(user.getId());
    }

    @PutMapping("/object/approve/{id}")
    public GameObject approveGameObject(@PathVariable int id){
        GameObject gameObject = gameObjectService.getGameObject(id);
        gameObject.setApproved(true);
        gameObjectService.saveGameObject(gameObject);
        return gameObject;
    }

}
