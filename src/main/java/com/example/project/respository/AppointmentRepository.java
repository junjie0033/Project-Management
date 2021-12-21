package com.example.project.respository;

import com.example.project.entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment,Integer> {

    List<Appointment> findAppointmentsByRenterId(int id);

    Appointment findByCarIdAndRenterIdAndStatus(int carId, int renterId, int status);

}
