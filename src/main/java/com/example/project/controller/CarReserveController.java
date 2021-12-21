package com.example.project.controller;

import com.example.project.controller.request.PayRequest;
import com.example.project.service.CarReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CarReserveController {

    @Autowired
    private final CarReserveService carReserveService;

    public CarReserveController(CarReserveService carReserveService) {
        this.carReserveService = carReserveService;
    }

    //车辆租赁交易
    @RequestMapping(value = "/payRent")
    public ResponseEntity<?> reserveCar(@RequestBody PayRequest request) {
        Map<String, String> map = new HashMap<>();
        map.put("message", "success");
        carReserveService.carReserve(request.getCarId(), request.getRenterId(), request.getDays(), request.getMoney());
        return ResponseEntity.ok(map);
    }
}
