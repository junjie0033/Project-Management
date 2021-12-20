package com.example.project.respository;

import com.example.project.entity.Record;
import com.example.project.entity.Records;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RecordRepository extends CrudRepository<Record,Integer> {
         Record getRecordByCarIdAndStatus(int carId,int status);

         @Query(value = "select record.id,car.address,brand,username,record.money, record.date,car_number as carNumber from record,user,car where record.car_id=car.id and record.renter_id=user.id and car.user_id=-1 and record.status=1", nativeQuery = true)
         List<Map<String,Object>> getRecords();
}
