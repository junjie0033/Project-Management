package com.example.project.respository;

import com.example.project.entity.Car;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car,Integer> {
     List<Car> findAllByStatus(int status);
     Car findById(int id);

    List<Car> findByUserId(int id);

     //分页查询，前端分页展示车辆信息
     @Query(value = "select * from car where car.status=0 limit ?1, ?2", nativeQuery = true)
     List<Car> getCarByPagingQuery(int pageNum, int pageSize);

     //全表全字段的模糊查询,用于前端的查询/筛选
     @Query(nativeQuery = true, value = "select * from car where concat_ws(',',price, car_type, car_number, address, money, brand) like ")
     List<Car> getCarWithFilter(String key);
}
