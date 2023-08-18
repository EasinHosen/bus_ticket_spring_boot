package com.kkeb.bus_ticket_flutter.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkeb.bus_ticket_flutter.entities.City;
import com.kkeb.bus_ticket_flutter.repos.CityRepository;
import com.kkeb.bus_ticket_flutter.services.CityService;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
    
}
