package com.example.project.junitTest;

import com.example.project.service.CarReserveService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CarReserveServiceTest {

    @Autowired
    private CarReserveService carReserveService;

    @BeforeEach
    void startTest() {
        System.out.println("start");
    }

    @AfterEach
    void endTest() {
        System.out.println("end");
    }

    @Test
    void carReserve() {
        carReserveService.carReserve(1,2,3,4);
    }
}
