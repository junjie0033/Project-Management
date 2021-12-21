package com.example.project.respository;

import com.example.project.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
      User findByUsername(String name);

      User findById(int id);
}
