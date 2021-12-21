package com.example.project.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InformationRequest {
    private int id;
    private String username;
    private int age;
    private int balance;
    private String phone;
}
