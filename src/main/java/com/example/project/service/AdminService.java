package com.example.project.service;

import com.example.project.entity.Car;
import com.example.project.entity.Fine;
import com.example.project.entity.Record;
import com.example.project.entity.Records;
import com.example.project.respository.CarRepository;
import com.example.project.respository.FineRepository;
import com.example.project.respository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class AdminService {


    @Autowired
    private final CarRepository carRepository;

    @Autowired
    private final FineRepository fineRepository;

    @Autowired
    private final RecordRepository recordRepository;

    @Autowired
    public AdminService(CarRepository carRepository, FineRepository fineRepository, RecordRepository recordRepository) {
        this.carRepository = carRepository;
        this.fineRepository = fineRepository;
        this.recordRepository = recordRepository;
    }

    //
    public List<Car> getRentedCar() {
        return carRepository.findAllByStatus(0);
    }


    public void deleteCar(int carId) {
        if (carRepository.findById(carId).getStatus()==0)
            carRepository.deleteById(carId);
    }

    public void addCar(Car car, MultipartFile image) throws IOException {
        moveImageToResource(image);
        carRepository.save(car);
    }

    private void moveImageToResource(MultipartFile image) throws IOException {
        File uploadDir = new File("/usr/local/fengqihang/static/img/");
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        //TODO
        File uploadFile = new File("/usr/local/fengqihang/static/img/"
                + image.getOriginalFilename());
        image.transferTo(uploadFile);
    }


    public void returned(int carId) {
        Record record = recordRepository.getRecordByCarIdAndStatus(carId, 1);
        record.setStatus(2);
        recordRepository.save(record);

        Car car = carRepository.findById(carId);
        car.setStatus(3);  //已归还
        carRepository.save(car);

    }

    public void continueRent(int carId) {
        Car car = carRepository.findById(carId);
        car.setStatus(0);
        carRepository.save(car);
    }

    public List<Map<String,Object>> getRecords(){
        return recordRepository.getRecords();
    }


    public void addFine(String recordId,String money,String reason){
        Fine fine=new Fine(Integer.parseInt(recordId),Double.parseDouble(money),reason);
        fineRepository.save(fine);
    }

}
