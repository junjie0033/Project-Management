package com.example.project.junitTest;

import com.example.project.service.CarRentalService;
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
class CarRentalServiceTest {

    @Autowired
    private CarRentalService carRentalService;

    @BeforeEach
    void startTest() {
        System.out.println("start");
    }

    @AfterEach
    void endTest() {
        System.out.println("end");
    }

    @Test
    void carRental() {
        carRentalService.carRental(1,1,1,1);
    }
}
