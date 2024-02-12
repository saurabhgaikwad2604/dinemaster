package com.example.dinemaster.repository;

import com.example.dinemaster.model.Restaurant;
import java.util.ArrayList;

public interface RestaurantRepository{
    ArrayList<Restaurant> getRestaurants();
    Restaurant getRestaurantById(int id);
    Restaurant addRestaurant(Restaurant restaurant);
    Restaurant updateRestaurant(int id, Restaurant restaurant);
    void deleteRestaurant(int id);
}