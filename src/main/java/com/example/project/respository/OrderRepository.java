package com.example.project.respository;

import com.example.project.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order,Integer> {
    List<Order> getOrderByRenterId(int id);

    Order getOrderById(int id);

    List<Order> getOrderByCarId(int id);
}
