package com.example.project.respository;

import com.example.project.entity.Fine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FineRepository extends CrudRepository<Fine,Integer> {

}
