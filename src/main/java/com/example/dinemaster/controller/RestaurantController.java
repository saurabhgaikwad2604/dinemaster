package com.example.dinemaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.service.RestaurantJpaService;

@RestController
public class RestaurantController {
    @Autowired
    public RestaurantJpaService restaurantService;

    @GetMapping("/restaurants")
    public ArrayList<Restaurant> getRestaurants() {
        return restaurantService.getRestaurants();
    }

    @GetMapping("/restaurants/{restaurantId}")
    public Restaurant getRestaurantById(@PathVariable("restaurantId") int restaurantId) {
        return restaurantService.getRestaurantById(restaurantId);
    }

    @PostMapping("/restaurants")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.addRestaurant(restaurant);
    }

    @PutMapping("/restaurants/{restaurantId}")
    public Restaurant updateRestaurant(@PathVariable("restaurantId") int restaurantId,
            @RequestBody Restaurant restaurant) {
        return restaurantService.updateRestaurant(restaurantId, restaurant);
    }

    @DeleteMapping("/restaurants/{restaurantId}")
    public void deleteRestaurant(@PathVariable("restaurantId") int restaurantId) {
        restaurantService.deleteRestaurant(restaurantId);
    }
}