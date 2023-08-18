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
import com.kkeb.bus_ticket_flutter.entities.City;
import com.kkeb.bus_ticket_flutter.models.ResponseModel;
import com.kkeb.bus_ticket_flutter.services.CityService;

@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    CityService cityService;

    @PostMapping("/add")
    public ResponseModel<City> addBus(@RequestBody City city) {
        final City savedCity = cityService.addCity(city);
        return new ResponseModel<City>(HttpStatus.OK.value(), "City Saved Successfully", savedCity);
    }

    @GetMapping("/all")
    public ResponseModel<List<City>> getAllBus() {
        return new ResponseModel<>(HttpStatus.OK.value(), "Data fetched successfully", cityService.getAllCities());
    }

}
