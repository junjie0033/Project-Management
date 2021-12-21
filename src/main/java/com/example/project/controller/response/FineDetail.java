package com.example.project.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class FineDetail {

    private Date date;  // 付款日期

    private int days;  //租车时间

    private double money;

    private String carNumber;

    private String brand;


}
