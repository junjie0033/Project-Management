package com.example.project.respository;

import com.example.project.entity.Car;
import com.example.project.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car,Integer> {

    List<Car> findByUserId(int id);

    Car findById(int id);

}
