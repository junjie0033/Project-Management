package com.example.project.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Fine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int orderId;

    private double money;
    private String reason;


    public Fine() {

    }

    public Fine(int orderId, double money, String reason) {
        this.orderId = orderId;
        this.money = money;
        this.reason = reason;
    }


}
