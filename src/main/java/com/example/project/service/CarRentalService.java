package com.example.project.service;

import com.example.project.entity.Appointment;
import com.example.project.entity.Car;
import com.example.project.respository.AppointmentRepository;
import com.example.project.respository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class CarRentalService {

    @Autowired
    private final AppointmentRepository appointmentRepository;

    @Autowired
    private final CarRepository carRepository;

    public CarRentalService(AppointmentRepository appointmentRepository, CarRepository carRepository) {
        this.appointmentRepository = appointmentRepository;
        this.carRepository = carRepository;
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

        Car car = carRepository.findById(carId);
        car.setStatus(1);
        carRepository.save(car);
    }
}
