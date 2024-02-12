package com.example.dinemaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.dinemaster.model.*;
import com.example.dinemaster.repository.*;

@Service
public class ChefJpaService implements ChefRepository {
    @Autowired
    private ChefJpaRepository chefJpaRepository;
    @Autowired
    private RestaurantJpaRepository restaurantJpaRepository;

    @Override
    public ArrayList<Chef> getChefs() {
        List<Chef> chefList = chefJpaRepository.findAll();
        ArrayList<Chef> chefs = new ArrayList<>(chefList);
        return chefs;
    }

    @Override
    public Chef getChefById(int id) {
        try {
            Chef chef = chefJpaRepository.findById(id).get();
            return chef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Chef addChef(Chef chef) {
        Restaurant restaurant = chef.getRestaurant();
        int restaurantId = restaurant.getId();
        Restaurant newRestaurant = restaurantJpaRepository.findById(restaurantId).get();
        chef.setRestaurant(newRestaurant);
        chefJpaRepository.save(chef);
        return chef;
    }

    @Override
    public Chef updateChef(int id, Chef chef) {
        try {
            Chef newChef = chefJpaRepository.findById(id).get();
            if (chef.getFirstName() != null) {
                newChef.setFirstName(chef.getFirstName());
            }
            if (chef.getLastName() != null) {
                newChef.setLastName(chef.getLastName());
            }
            if (chef.getExpertise() != null) {
                newChef.setExpertise(chef.getExpertise());
            }
            if (chef.getExperienceYear() != null) {
                newChef.setExperienceYear(chef.getExperienceYear());
            }
            if (chef.getRestaurant() != null) {
                Restaurant restaurant = chef.getRestaurant();
                int restaurantId = restaurant.getId();
                try {
                    Restaurant newRestaurant = restaurantJpaRepository.findById(restaurantId).get();
                    chef.setRestaurant(newRestaurant);
                } catch (Exception e) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
            }
            chefJpaRepository.save(newChef);
            return newChef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteChef(int id) {
        if (chefJpaRepository.existsById(id)) {
            chefJpaRepository.deleteById(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Restaurant getRestaurantByChefId(int id) {
        Chef chef = chefJpaRepository.findById(id).get();
        Restaurant restaurant = chef.getRestaurant();
        return restaurant;
    }
}