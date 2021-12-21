package com.example.project.junitTest;

import com.example.project.entity.Car;
import com.example.project.respository.CarRepository;
import com.example.project.service.GetAllCarInfoService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class GetAllCarInfoServiceTest {


    @Autowired
    private GetAllCarInfoService getAllCarInfoService;
//
//    GetAllCarInfoServiceTest(GetAllCarInfoService getAllCarInfoService) {
//        this.getAllCarInfoService = getAllCarInfoService;
//    }

    @BeforeEach
    void startTest() {
        System.out.println("start");
    }

    @AfterEach
    void endTest() {
        System.out.println("end");
    }


    @Test
    void getCarInfoByPagingQuery() {
        List<Car> list = getAllCarInfoService.getCarInfoByStatus();
        for (Car car:list) {
            System.out.println(car.getId());
        }

    }

    @Test
    void getCarWithFilter() {
        List<Car> list = getAllCarInfoService.getWithFilter("2");
        for (Car car:list) {
            System.out.println(car.getId());
        }
    }

    @Test
    void testCode() {
        Date date = new Date();
        System.out.println(date);
        System.out.println("------");
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1);

    }

}
