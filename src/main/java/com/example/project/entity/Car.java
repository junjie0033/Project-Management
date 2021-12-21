package com.example.project.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String carNumber;

    private int userId;  // -1 就是平台车

    private String carType;  //suv 越野车 跑车

    private String brand; //品牌

    private double price;  //  元/天

    private String image; //存图片路径

    private String address;

    private int status;//待出租0 已预约1 已出租2 已归还3

    public Car() {
    }

    public Car(String carNumber, int userId, String carType, String brand, double price, String image, String address,int status) {
        this.carNumber = carNumber;
        this.userId = userId;
        this.carType = carType;
        this.brand = brand;
        this.price = price;
        this.image = image;
        this.address = address;
        this.status=status;
    }


}
