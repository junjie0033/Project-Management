package com.example.project.service;

import com.example.project.entity.Appointment;
import com.example.project.respository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class CarRentalService {

    @Autowired
    private final AppointmentRepository appointmentRepository;

    public CarRentalService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    public void carRental(int carId, int rentalId, int retentionDays, double money) {
        Appointment appointment = new Appointment();
        appointment.setCarId(carId);
        appointment.setRenterId(rentalId);
        appointment.setDate(new Date(new java.util.Date().getTime()));
        appointment.setDays(retentionDays);
        appointment.setMoney(money);
        appointment.setStatus(0);
        appointmentRepository.save(appointment);
    }
}
