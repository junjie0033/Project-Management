package com.example.project.respository;

import com.example.project.entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment,Integer> {
    Appointment findByCarIdAndRenterIdAndStatus(int carId, int renterId, int status);
}
