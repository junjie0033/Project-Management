package com.example.project.controller;

import com.example.project.entity.Garage;
import com.example.project.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class GarageController {

    @Autowired
    private final GarageService garageService;


    @Autowired
    public GarageController(GarageService garageService){
        this.garageService=garageService;
    }


    //添加店铺
    @RequestMapping(value = "/addGarage")
    public void addGarage(@Param("name") String name,@Param("address") String address,@Param("discount") String discount){
        HashMap<String,Object> map=new HashMap<>();
        Garage garage=new Garage(name,address,discount);
        garageService.addGarage(garage);
    }

    //根据地址搜索店铺
    @RequestMapping(value = "/getGarage")
    public ResponseEntity<?> getGarage(@Param("address") String address){
        HashMap<String,Object> map=new HashMap<>();
        map.put("garage",garageService.getGarage(address));

        return ResponseEntity.ok(map);
    }


    //获取所有店铺
    @RequestMapping(value = "/getAllGarage")
    public ResponseEntity<?> getAllGarage(){
        HashMap<String,Object> map=new HashMap<>();
        map.put("garages",garageService.getAllGarage());

        return ResponseEntity.ok(map);
    }


}
