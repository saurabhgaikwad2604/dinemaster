package com.example.dinemaster.repository;

import java.util.ArrayList;
import com.example.dinemaster.model.*;

public interface ChefRepository{
    ArrayList<Chef> getChefs();
    Chef getChefById(int id);
    Chef addChef(Chef chef);
    Chef updateChef(int id, Chef chef);
    void deleteChef(int id);
    Restaurant getRestaurantByChefId(int id);
}