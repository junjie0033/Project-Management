package com.example.project.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int renterId;

    private int carId;

    private Date date; //啥时候开始预约的

    private int days;  // 保留预约几天

    private double money;// 预约金 = 天数 * 固定值
    private int status;  // 过期或者已取车作废

    public Appointment() {

    }

    public Appointment(int renterId, int carId, Date date, int days, double money, int status) {
        this.renterId = renterId;
        this.carId = carId;
        this.date = date;
        this.days = days;
        this.money = money;
        this.status = status;
    }


}
