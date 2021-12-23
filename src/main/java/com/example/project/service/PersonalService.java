package com.example.project.service;

import com.example.project.controller.request.InformationRequest;
import com.example.project.controller.response.CarDetail;
import com.example.project.controller.response.FineDetail;
import com.example.project.entity.*;
import com.example.project.respository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonalService {

    private RecordRepository orderRepository;
    private UserRepository userRepository;
    private CarRepository carRepository;
    private AppointmentRepository appointmentRepository;
    private FineRepository fineRepository;

    @Autowired
    public PersonalService(RecordRepository orderRepository, UserRepository userRepository, CarRepository carRepository,
                           AppointmentRepository appointmentRepository, FineRepository fineRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.appointmentRepository = appointmentRepository;
        this.fineRepository = fineRepository;
    }

    public List<Record> getOrderByRenterId(int id) {
        List<Record> orders = orderRepository.getOrderByRenterId(id);
        return orders.stream().filter(order -> order.getStatus() != 2).collect(Collectors.toList());
    }

    public List<Appointment> getAppointmentByRenterId(int id) {
        List<Appointment> list = appointmentRepository.findAppointmentsByRenterId(id);

        return list.stream().filter(appointment -> appointment.getStatus() == 0).collect(Collectors.toList());
    }

    public List<Fine> getFineByUserId(int id) {
        return fineRepository.findFinesByUserId(id).stream().filter(fine -> fine.getStatus() == 0)
                .collect(Collectors.toList());
    }

    public boolean saveInformation(InformationRequest request) {
        User user = userRepository.findById(request.getId());
        user.setAge(request.getAge());
        user.setBalance(request.getBalance());
        user.setPhone(request.getPhone());
        userRepository.save(user);
        return true;
    }

    public List<Car> getMyCars(int id) {
        return carRepository.findByUserId(id);
    }

    public boolean confirmReceive(int id) {
        Record order = orderRepository.getOrderById(id);
        order.setStatus(1);
        System.out.println(order.getStatus());
        orderRepository.save(order);
        return true;
    }

    /**
     * 需要判断是否为私人车
     * @param
     * @return
     */
    @Transactional
    public boolean confirmReturn(int carId, int userId) {
        Car car = carRepository.findById(carId);
        car.setStatus(3);
        List<Record> orders = orderRepository.getOrderByCarId(carId);

        Record order = orders.stream().filter(order1 -> order1.getStatus() != 2).findFirst().get();
        order.setStatus(2);
        carRepository.save(car);
        orderRepository.save(order);

        if(userId != -1) {
            User user = userRepository.findById(userId);
            //advise double
            user.setBalance(user.getBalance() + order.getMoney() * 0.95);
        }

        return true;
    }

    public boolean continueRent(int id) {
        Car car = carRepository.findById(id);
        car.setStatus(0);
        carRepository.save(car);
        return true;
    }

    public CarDetail getCarDetail(int id) {
        Car car = carRepository.findById(id);

        CarDetail detail = new CarDetail(car.getCarNumber(), car.getUserId(), car.getCarType(), car.getBrand(), car.getPrice(),
                car.getImage(), car.getAddress());

        return detail;
    }

    public boolean payTicket(int id) {
        Fine fine = fineRepository.findFinesById(id);
        fine.setStatus(1);

        fineRepository.save(fine);
        return true;
    }

    public Car getCar(int id) {
        return carRepository.findById(id);
    }

    public FineDetail getFineDetail(int id) {
        Fine fine = fineRepository.findFinesById(id);

        int orderId = fine.getOrderId();

        Record order = orderRepository.getOrderById(orderId);

        Car car = carRepository.findById(order.getCarId());

        FineDetail detail = new FineDetail(order.getDate(),order.getDays(), order.getMoney(), car.getCarNumber(), car.getBrand());

        return detail;
    }

}
