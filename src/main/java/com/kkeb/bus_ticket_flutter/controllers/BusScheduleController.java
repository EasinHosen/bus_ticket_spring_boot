package com.kkeb.bus_ticket_flutter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kkeb.bus_ticket_flutter.entities.BusSchedule;
import com.kkeb.bus_ticket_flutter.models.ResponseModel;
import com.kkeb.bus_ticket_flutter.services.BusScheduleService;

@RestController
@RequestMapping("/api/schedule")
public class BusScheduleController {
    
    @Autowired
    private BusScheduleService busScheduleService;

    @PostMapping("/add")
    public ResponseModel<BusSchedule> addBusSchedule(@RequestBody BusSchedule busSchedule){
        final BusSchedule newSchedule = busScheduleService.addSchedule(busSchedule);

        return new ResponseModel<>(HttpStatus.OK.value(), "Schedule Added Successfully", newSchedule);
    }

    @GetMapping("/all")
    public ResponseModel<List<BusSchedule>> getAllSchedules(){
        return new ResponseModel<>(HttpStatus.OK.value(), "Schedules fetched successfully", busScheduleService.getAllBusSchedules());
    }

    @GetMapping("/{routeName}")
    public ResponseModel<List<BusSchedule>> getBusScheduleByRouteName(@PathVariable(name ="routeName") String routeName){
        return new ResponseModel<>(HttpStatus.OK.value(), "Schedules fetched successfully", busScheduleService.getSchedulesByRoute(routeName));
    }
}
