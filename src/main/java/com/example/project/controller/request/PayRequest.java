package com.example.project.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PayRequest {
    private int renterId;
    private int carId;
    private int days;
    private double money;

}
