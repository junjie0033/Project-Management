package com.example.project.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Records {

    private int id;   //订单id

    private String username;  //租车人

    private Date date;   //付款日期

    private String carNumber;

    private double money;

    private String brand;

    private String carType;




}
