package com.example.dinemaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.example.dinemaster.model.*;
import com.example.dinemaster.service.ChefJpaService;

@RestController
public class ChefController {
    @Autowired
    public ChefJpaService chefService;

    @GetMapping("/restaurants/chefs")
    public ArrayList<Chef> getChefs() {
        return chefService.getChefs();
    }

    @GetMapping("/restaurants/chefs/{chefId}")
    public Chef getChefById(@PathVariable("chefId") int chefId) {
        return chefService.getChefById(chefId);
    }

    @GetMapping("/chefs/{chefId}/restaurant")
    public Restaurant getRestaurantByChefId(@PathVariable("chefId") int chefId) {
        return chefService.getRestaurantByChefId(chefId);
    }

    @PostMapping("/restaurants/chefs")
    public Chef addChef(@RequestBody Chef chef) {
        return chefService.addChef(chef);
    }

    @PutMapping("/restaurants/chefs/{chefId}")
    public Chef updateChef(@PathVariable("chefId") int chefId, @RequestBody Chef chef) {
        return chefService.updateChef(chefId, chef);
    }

    @DeleteMapping("/restaurants/chefs/{chefId}")
    public void deleteChef(@PathVariable("chefId") int chefId) {
        chefService.deleteChef(chefId);
    }
}