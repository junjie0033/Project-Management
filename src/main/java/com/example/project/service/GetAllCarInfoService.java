package com.example.project.service;

import com.example.project.entity.Car;
import com.example.project.respository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCarInfoService {

    @Autowired
    private final CarRepository carRepository;

    public GetAllCarInfoService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public List<Car> getCarInfoByStatus() {
        return carRepository.findAllByStatus(0);
    }

    public List<Car> pageQuery(int pageNum, int pageSize) {
        return carRepository.getCarByPagingQuery(pageNum, pageSize);
    }

    public List<Car> getWithFilter(String key) {
        return carRepository.getCarWithFilter(key);
    }

}
