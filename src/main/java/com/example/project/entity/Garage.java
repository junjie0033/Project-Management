package com.example.project.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String name;

    private String address;

    private String discount; //优惠


    public Garage() {

    }
    public Garage(String name, String address, String discount) {
        this.name = name;
        this.address = address;
        this.discount = discount;
    }



}
