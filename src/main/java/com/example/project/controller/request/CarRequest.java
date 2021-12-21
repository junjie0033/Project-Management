package com.example.project.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRequest {
    private int id;

    private String carNumber;

    private int userId;  // -1 就是平台车

    private String carType;  //suv 越野车 跑车

    private String brand; //品牌

    private double price;  //  元/天

    private String image; //存图片路径

    private String address;

    private int status;//待出租0 已预约1 已出租2 已归还3
}
