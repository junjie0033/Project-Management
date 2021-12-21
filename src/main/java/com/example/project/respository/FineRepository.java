package com.example.project.respository;

import com.example.project.entity.Fine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FineRepository extends CrudRepository<Fine,Integer> {
    List<Fine> findFinesByUserId(int id);

    Fine findFinesById(int id);
}
