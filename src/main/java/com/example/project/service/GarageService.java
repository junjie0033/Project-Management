package com.example.project.service;

import com.example.project.entity.Garage;
import com.example.project.respository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageService {

    @Autowired
    private final GarageRepository garageRepository;


    public GarageService(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    public void addGarage(Garage garage) {
        garageRepository.save(garage);
    }

    public List<Garage> getGarage(String address) {
        return garageRepository.findAllByAddressLike(address);
    }

    public List<Garage> getAllGarage() {
        return garageRepository.findAll();
    }
}
