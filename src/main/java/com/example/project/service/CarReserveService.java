package com.example.project.service;

import com.example.project.entity.Appointment;
import com.example.project.entity.Car;
import com.example.project.entity.Record;
import com.example.project.entity.User;
import com.example.project.respository.AppointmentRepository;
import com.example.project.respository.CarRepository;
import com.example.project.respository.RecordRepository;
import com.example.project.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class CarReserveService {

    @Autowired
    private final RecordRepository recordRepository;

    @Autowired
    private final AppointmentRepository appointmentRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final CarRepository carRepository;

    public CarReserveService(RecordRepository recordRepository, AppointmentRepository appointmentRepository, UserRepository userRepository, CarRepository carRepository) {
        this.recordRepository = recordRepository;
        this.appointmentRepository = appointmentRepository;
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }

    @Transactional
    public void carReserve(int carId, int renterId, int rentalDays, double money) {
        Record record = new Record(carId, renterId, new Date(new java.util.Date().getTime()),rentalDays,money,0);
        recordRepository.save(record);
        Appointment appointment = appointmentRepository.findByCarIdAndRenterIdAndStatus(carId, renterId, 0);
        if(appointment != null) {
            double appointMoney = appointment.getMoney();
            User user = userRepository.findById(renterId);
            user.setBalance(user.getBalance()+appointMoney);
            userRepository.save(user);
        }

        Car car = carRepository.findById(carId);
        car.setStatus(2);
        carRepository.save(car);
    }

}
