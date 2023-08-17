package com.kkeb.bus_ticket_flutter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kkeb.bus_ticket_flutter.entities.Bus;
import com.kkeb.bus_ticket_flutter.models.ResponseModel;
import com.kkeb.bus_ticket_flutter.services.BusService;

@RestController
@RequestMapping("/api/bus")
public class BusController{

    @Autowired
    private BusService busService;

    @PostMapping("/add")
    public ResponseModel<Bus> addBus(@RequestBody Bus bus){
        final Bus savedBus = busService.addBus(bus);
        return new ResponseModel<Bus>(HttpStatus.OK.value(), "Bus Saved Successfully", savedBus);
    }

    @GetMapping("/all")
    public ResponseModel<List<Bus>> getAllBus(){
        return new ResponseModel<>(HttpStatus.OK.value(), "Data fetch successfully", busService.getAllBus());
    }

}