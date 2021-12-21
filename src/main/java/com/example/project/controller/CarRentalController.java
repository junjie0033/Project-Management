package com.example.project.controller;

import com.example.project.controller.request.PayRequest;
import com.example.project.entity.Appointment;
import com.example.project.service.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CarRentalController {

    @Autowired
    private final CarRentalService carRentalService;

    public CarRentalController(CarRentalService carRentalService) {
        this.carRentalService = carRentalService;
    }

    //车辆预约交易
    @RequestMapping(value = "/payAppoint")
    public ResponseEntity<?> rentalCar(@RequestBody PayRequest request){
        Map<String, String> map = new HashMap<>();
        map.put("message", "success");
        carRentalService.carRental(request.getCarId(), request.getRenterId(), request.getDays(), request.getMoney());
        return ResponseEntity.ok(map);
    }
}
