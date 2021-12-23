package com.example.project.controller;

import com.example.project.controller.request.CarRequest;
import com.example.project.controller.request.InformationRequest;
import com.example.project.controller.response.CarDetail;
import com.example.project.controller.response.FineDetail;
import com.example.project.entity.Appointment;
import com.example.project.entity.Car;
import com.example.project.entity.Fine;
import com.example.project.entity.Record;
import com.example.project.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;

@RestController
public class PersonalController {

    private final PersonalService service;

    @Autowired
    public PersonalController(PersonalService service) {
        this.service = service;
    }

    /**
     * order根据status分为正在进行的订单和已经完成的订单，即历史订单
     * @param
     * @return
     */
    @PostMapping("/getRent")
    public ResponseEntity<?> getOrders(@RequestBody HashMap<String, Object> params) {
        int id = (Integer) params.get("userId");
        List<Record> orders = service.getOrderByRenterId(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("message", "success");
        map.put("orders", orders);

        return ResponseEntity.ok(map);
    }

    @PostMapping("uploadCar")
    public ResponseEntity<?> uploadCar(@RequestBody HashMap<String, Object> map) {
        return null;
    }


    @PostMapping("/getMyAppointment")
    public ResponseEntity<?> getAppoint(@RequestBody HashMap<String, Object> params) {
        int id = (Integer) params.get("userId");
        List<Appointment> appointments = service.getAppointmentByRenterId(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("message", "success");
        map.put("appointments", appointments);

        return ResponseEntity.ok(map);
    }

    @PostMapping("/getTicket")
    public ResponseEntity<?> getFines(@RequestBody HashMap<String, Object> params) {
        int id = (Integer) params.get("userId");
        List<Fine> tickets = service.getFineByUserId(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("message", "success");
        map.put("ticket", tickets);

        return ResponseEntity.ok(map);
    }

    @PostMapping("/saveInformation")
    public ResponseEntity<?> saveInformation(@RequestBody InformationRequest request ) {
        HashMap<String, Object> map = new HashMap<>();

        if(service.saveInformation(request)) {
            map.put("message", "success");
        } else {
            map.put("message", "failure");
        }

        return ResponseEntity.ok(map);
    }

    @PostMapping("/getMyCars")
    public ResponseEntity<?> getMyCars(@RequestBody HashMap<String, Object> params) {
        int id = (Integer) params.get("user");
        HashMap<String, Object> map = new HashMap<>();
        List<Car> cars = service.getMyCars(id);
        map.put("message", "success");
        map.put("cars", cars);

        return ResponseEntity.ok(map);
    }

    @PostMapping("/confirmReceive")
    public ResponseEntity<?> confirmReceive(@RequestBody HashMap<String, Object> params) {
        int id = (Integer) params.get("carId");
        HashMap<String, Object> map = new HashMap<>();

        if(service.confirmReceive(id)) {
            map.put("message", "success");
        } else {
            map.put("message", "failure");
        }

        return ResponseEntity.ok(map);
    }

    @PostMapping("/confirmReturn")
    public ResponseEntity<?> confirmReturn(@RequestBody HashMap<String, Object> params) {
        int id = (Integer) params.get("id");
        int userId = (Integer) params.get("userId");
        HashMap<String, Object> map = new HashMap<>();
        if(service.confirmReturn(id, userId)) {
            map.put("message", "success");
        } else {
            map.put("message", "failure");
        }

        return ResponseEntity.ok(map);
    }

    @PostMapping("/continueRent")
    public ResponseEntity<?> continueRent(@RequestBody HashMap<String, Object> params) {
        int id = (Integer) params.get("id");
        HashMap<String, Object> map = new HashMap<>();
        if(service.continueRent(id)) {
            map.put("message", "success");
        } else {
            map.put("message", "failure");
        }

        return ResponseEntity.ok(map);
    }

    @PostMapping("/applyTicket")
    public ResponseEntity<?> applyTicket(@RequestParam("id") Integer id) {

        return null;
    }

    @PostMapping("/carDetail")
    public ResponseEntity<?> carDetail(@RequestBody HashMap<String, Object> params) {
        int id = (Integer) params.get("carId");
        HashMap<String, Object> map = new HashMap<>();

        CarDetail detail = service.getCarDetail(id);

        map.put("message", "success");
        map.put("carDetail", detail);

        return ResponseEntity.ok(map);
    }

    @PostMapping("payTicket")
    public ResponseEntity<?> payTicket(@RequestParam("id") Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        if(service.payTicket(id)) {
            map.put("message", "success");
        } else {
            map.put("message", "failure");
        }

        return ResponseEntity.ok(map);
    }

    @PostMapping("/fineDetail")
    public ResponseEntity<?> fineDetail(@RequestBody HashMap<String, Object> params) {
        int id = (Integer) params.get("id");
        HashMap<String, Object> map = new HashMap<>();

        FineDetail detail = service.getFineDetail(id);

        map.put("message", "success");
        map.put("fineDetail", detail);

        return ResponseEntity.ok(map);
    }

    @PostMapping("getCar")
    public ResponseEntity<?> getCar(@RequestBody HashMap<String, Object> params) {
        int id = (Integer) params.get("carId");
        HashMap<String, Object> map = new HashMap<>();

        Car car = service.getCar(id);

        map.put("message", "success");
        map.put("car", car);

        return ResponseEntity.ok(map);
    }

}
