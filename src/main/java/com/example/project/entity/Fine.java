package com.example.project.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Fine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int userId;

    private int orderId;

    private Date date;
    private double money;
    private String reason;

    private int status; //罚单, 0未支付， 1支付


    public Fine() {

    }

    public Fine(int userId, int orderId, double money, String reason, Date date) {
        this.userId = userId;
        this.orderId = orderId;
        this.money = money;
        this.reason = reason;
        this.date = date;
    }


}
