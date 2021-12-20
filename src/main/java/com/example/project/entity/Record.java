package com.example.project.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int carId;

    private int renterId;  //去租车的人

    private Date date;  // 付款日期

    private int days;  //租车时间

    private double money;

    private int status;  //未取车0 已取车1 已还车 2

    public Record() {
    }

    public Record(int carId, int renterId, Date date, int days, double money, int status) {
        this.carId = carId;
        this.renterId = renterId;
        this.date = date;
        this.days = days;
        this.money = money;
        this.status = status;
    }

}
