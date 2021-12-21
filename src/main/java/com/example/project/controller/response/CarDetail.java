package com.example.project.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarDetail {

    private String carNumber;

    private int userId;  // -1 就是平台车

    private String carType;  //suv 越野车 跑车

    private String brand; //品牌

    private double price;  //  元/天

    private String image; //存图片路径

    private String address;
}
