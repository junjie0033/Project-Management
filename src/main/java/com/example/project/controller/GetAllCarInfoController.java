package com.example.project.controller;

import com.example.project.service.GetAllCarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class GetAllCarInfoController {

    @Autowired
    private final GetAllCarInfoService getAllCarInfoService;


    public GetAllCarInfoController(GetAllCarInfoService getAllCarInfoService) {
        this.getAllCarInfoService = getAllCarInfoService;
    }

    //获取所有车辆信息
    @RequestMapping(value = "/getCars")
    public ResponseEntity<?> getAllGarage(){
        HashMap<String,Object> map=new HashMap<>();
        map.put("cars",getAllCarInfoService.getCarInfoByStatus());
        return ResponseEntity.ok(map);
    }
}
