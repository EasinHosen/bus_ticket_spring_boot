package com.kkeb.bus_ticket_flutter.services;

import java.util.List;

import com.kkeb.bus_ticket_flutter.entities.City;

public interface CityService {
    City addCity(City city);
    
    List<City> getAllCities();
}
