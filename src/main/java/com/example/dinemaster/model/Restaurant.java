package com.example.dinemaster.model;

import javax.persistence.*;

@Entity
@Table(name = "restaurant")
public class Restaurant{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "cuisinetype")
    private String cuisineType;
    @Column(name = "rating")
    private Integer rating;

    public Restaurant(){}
    public Restaurant(int id, String name, String address, String cuisineType, Integer rating){
        this.id = id;
        this.name = name;
        this.address = address;
        this.cuisineType = cuisineType;
        this.rating = rating;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public String getCuisineType(){
        return cuisineType;
    }
    public void setCuisineType(String cuisineType){
        this.cuisineType = cuisineType;
    }

    public Integer getRating(){
        return rating;
    }
    public void setRating(Integer rating){
        this.rating = rating;
    }
}