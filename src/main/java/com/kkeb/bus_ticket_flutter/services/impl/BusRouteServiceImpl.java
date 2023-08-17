package com.kkeb.bus_ticket_flutter.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.kkeb.bus_ticket_flutter.entities.BusRoute;
import com.kkeb.bus_ticket_flutter.models.ReservationAPIException;
import com.kkeb.bus_ticket_flutter.repos.BusRouteRepository;
import com.kkeb.bus_ticket_flutter.services.BusRouteService;

@Service
public class BusRouteServiceImpl implements BusRouteService {

    @Autowired
    private BusRouteRepository busRouteRepository;

    @Override
    public BusRoute addRoute(BusRoute busRoute) {
        return busRouteRepository.save(busRoute);
    }

    @Override
    public List<BusRoute> getAllBusRoutes() {
        return busRouteRepository.findAll();
    }

    @Override
    public BusRoute getRouteByRouteName(String routeName) {
        return busRouteRepository.findByRouteName(routeName)
                .orElseThrow(() -> new ReservationAPIException(HttpStatus.BAD_REQUEST, "No such route found!"));

    }

    @Override
    public BusRoute getRouteByCityFromAndCityTo(String cityFrom, String cityTo) {
        return busRouteRepository.findByCityFromAndCityTo(cityFrom, cityTo)
                .orElseThrow(() -> new ReservationAPIException(HttpStatus.BAD_REQUEST, "No such route found!"));
    }

}
