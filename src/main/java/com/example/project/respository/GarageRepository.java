package com.example.project.respository;

import com.example.project.entity.Garage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarageRepository extends CrudRepository<Garage,Integer> {
}
