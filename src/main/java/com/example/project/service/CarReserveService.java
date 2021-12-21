package com.example.project.service;

import com.example.project.entity.Appointment;
import com.example.project.entity.Record;
import com.example.project.entity.User;
import com.example.project.respository.AppointmentRepository;
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

    public CarReserveService(RecordRepository recordRepository, AppointmentRepository appointmentRepository, UserRepository userRepository) {
        this.recordRepository = recordRepository;
        this.appointmentRepository = appointmentRepository;
        this.userRepository = userRepository;
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
    }

}
