package com.example.project.respository;

import com.example.project.entity.Garage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GarageRepository extends CrudRepository<Garage,Integer> {
    List<Garage> findAllByAddressLike(String address);
    List<Garage> findAll();
}
