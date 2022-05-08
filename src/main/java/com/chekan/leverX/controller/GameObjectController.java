package com.chekan.leverX.controller;

import com.chekan.leverX.entity.GameObject;
import com.chekan.leverX.entity.User;
import com.chekan.leverX.exceptions.MyNoSuchElementException;
import com.chekan.leverX.service.GameObjectService;
import com.chekan.leverX.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/gameObjects")
public class GameObjectController {

    @Autowired
    private GameObjectService gameObjectService;

    @Autowired
    private UserService userService;

//    @PostMapping("/object")
//    public GameObject addNewGameObject(@RequestBody GameObject gameObject) {
//        gameObject.setCreatedAt(new Date(System.currentTimeMillis()));
//        gameObject.setApproved(false);
//        gameObjectService.saveGameObject(gameObject);
//        return gameObject;
//    }

    @GetMapping("viewGO")
    public String show(GameObject gameObject) {
        return "addGameObject";
    }

    @PostMapping("/add")
    public String addNewGameObject(@Valid GameObject gameObject, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addGameObject";
        }
        gameObject.setCreatedAt(new Date(System.currentTimeMillis()));
        gameObject.setApproved(false);
        gameObjectService.saveGameObject(gameObject);
        return "redirect:list";
    }

    @GetMapping("/objects/approvedList")
    public List<GameObject> showApprovedGameObjects() {
        List<GameObject> allGameObjects = gameObjectService.getAllGameObjects();
        List<GameObject> approvedGameObjects = new ArrayList<>();
        for (GameObject object : allGameObjects) {
            if (object.isApproved() == true) {
                approvedGameObjects.add(object);
            }
        }
        return approvedGameObjects;
    }

//    @GetMapping("/approvedList")
//    public String showApprovedGameObjects(Model model) {
//        List<GameObject> allGameObjects = gameObjectService.getAllGameObjects();
//        List<GameObject> approvedGameObjects = new ArrayList<>();
//        for (GameObject object : allGameObjects) {
//            if (object.isApproved() == true) {
//                approvedGameObjects.add(object);
//            }
//        }
//        System.out.println(approvedGameObjects);
//        model.addAttribute("gameObjects", approvedGameObjects);
//        return "listOfGameOblect";
//    }

//    @GetMapping("/admin/object")
//    public List<GameObject> showAllGameObjects() {
//        List<GameObject> allGameObjects = gameObjectService.getAllGameObjects();
//        return allGameObjects;
//    }

    @GetMapping("/list")
    public String showAllGameObjects(Model model) {
        model.addAttribute("gameObjects", gameObjectService.getAllGameObjects());
        return "listOfGameObject";
    }

    @DeleteMapping("/object/{id}")
    public String deleteGameObject(@PathVariable int id) {
        GameObject gameObject = gameObjectService.getGameObject(id);
        if (gameObject == null) {
            return "There is no game object with ID = " + id + " in Database";
        } else {
            gameObjectService.deleteGameObject(id);
            return "Game object with ID = " + id + " was deleted.";
        }
    }

//    @PutMapping("/object/{id}")
//    public GameObject updateGameObject(@RequestBody GameObject gameObject, @PathVariable int id) {
//        GameObject gameObject1 = gameObjectService.getGameObject(id);
//        if (gameObject1 == null) {
//            throw new MyNoSuchElementException("There is no game object with ID = " + id + " in Database");
//        }
//        gameObject1.setApproved(false);
//        gameObject1.setTitle(gameObject.getTitle());
//        gameObject1.setText(gameObject.getText());
//        gameObject1.setUpdatedAt(new Date(System.currentTimeMillis()));
//        gameObjectService.saveGameObject(gameObject1);
//        return gameObject1;
//    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model){
        GameObject gameObject = gameObjectService.getGameObject(id);
        model.addAttribute("gameObject", gameObject);
        return "updateGameObject";
    }

    @PostMapping("/update/{id}")
    public String updateGameObject(@PathVariable("id") int id, @Valid GameObject gameObject, BindingResult result,
                                   Model model) {
        if (result.hasErrors()) {
            gameObject.setId(id);
            return "updateGameObject";
        }
        gameObject.setApproved(false);
        gameObject.setUpdatedAt(new Date(System.currentTimeMillis()));
        gameObjectService.saveGameObject(gameObject);
        model.addAttribute("gameObjects", gameObjectService.getAllGameObjects());
        return "listOfGameObject";
    }

    @GetMapping("/my")
    public List<GameObject> showAllMyGameObjects(Principal principal) {
        User user = userService.getByUserEmail(principal.getName());
        return gameObjectService.getAllGameObjectsByUserId(user.getId());
    }

    @PutMapping("/object/approve/{id}")
    public GameObject approveGameObject(@PathVariable int id) {
        GameObject gameObject = gameObjectService.getGameObject(id);
        if (gameObject == null) {
            throw new MyNoSuchElementException("There is no game object with ID = " + id + " in Database");
        }
        gameObject.setApproved(true);
        gameObjectService.saveGameObject(gameObject);
        return gameObject;
    }

}
