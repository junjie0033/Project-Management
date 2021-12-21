package com.example.project.controller;

import com.example.project.entity.Car;

import com.example.project.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AdminController {


    @Autowired
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    //不管是个人还是私有,改成了未出租的车，方便你删除
    @RequestMapping(value = "/getRenderCar")
    public ResponseEntity<?> getRentedCar() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("cars", adminService.getRentedCar());
        return ResponseEntity.ok(map);
    }


    //删除未出租的车
    @RequestMapping(value = "/deleteCar")
    public ResponseEntity<?> deleteCar(@Param("id") String id) {
        adminService.deleteCar(Integer.parseInt(id));
        return null;
    }


    @RequestMapping(value = "/updateCar")
    public ResponseEntity<?> updateCar(@RequestParam("image") MultipartFile image,
                                       @RequestParam("carNumber") String carNumber,
                                       @RequestParam("carType") String carType,
                                       @RequestParam("brand") String brand,
                                       @RequestParam("price") String price,
                                       @RequestParam("address") String address
    ) throws Exception {
        HashMap<String, Object> map = new
                HashMap<>();
        Car car = new Car(carNumber, -1, carType, brand, Double.parseDouble(price), image.getOriginalFilename(), address, 0);
        adminService.addCar(car, image);
        map.put("success", "上传成功");
        return ResponseEntity.ok(map);
    }

    @RequestMapping(value = "/getRecord")
    public ResponseEntity<?> getRecord() {
        List<Map<String,Object>> records = adminService.getRecords();
        HashMap<String, Object> map = new HashMap<>();
        map.put("records", records);

        return ResponseEntity.ok(map);
    }


    //平台车辆归还
    @RequestMapping(value = "/returnCar")
    public ResponseEntity<?> returnCar(@RequestParam("id") String carId) {
        adminService.returned(Integer.parseInt(carId));
        return null;
    }

    @RequestMapping(value = "/continueRent")
    public void continueRent(@RequestParam("id") String carId) {
        adminService.continueRent(Integer.parseInt(carId));
    }


    //罚款
    @RequestMapping(value = "/fine")
    public ResponseEntity<?> fine(@Param("id") String orderId, @Param("money") String money, @Param("reason") String reason) {
        HashMap<String, Object> map = new HashMap<>();
        adminService.addFine(orderId, money, reason);
        map.put("success", "生成罚单成功");
        return ResponseEntity.ok(map);
    }
}
