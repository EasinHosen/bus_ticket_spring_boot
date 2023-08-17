package com.kkeb.bus_ticket_flutter.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.kkeb.bus_ticket_flutter.entities.BusRoute;
import com.kkeb.bus_ticket_flutter.entities.BusSchedule;
import com.kkeb.bus_ticket_flutter.models.ReservationAPIException;
import com.kkeb.bus_ticket_flutter.repos.BusRouteRepository;
import com.kkeb.bus_ticket_flutter.repos.BusScheduleRepository;
import com.kkeb.bus_ticket_flutter.services.BusScheduleService;

@Service
public class BusScheduleServiceImpl implements BusScheduleService {

    @Autowired
    private BusScheduleRepository busScheduleRepository;

    @Autowired
    private BusRouteRepository busRouteRepository;

    @Override
    public BusSchedule addSchedule(BusSchedule busSchedule) throws ReservationAPIException {
        final boolean exists = 
            busScheduleRepository.existsByBusAndBusRouteAndDepartureTime(
                busSchedule.getBus(),
                busSchedule.getBusRoute(), 
                busSchedule.getDepartureTime());

        if (exists) {
            throw new ReservationAPIException(HttpStatus.CONFLICT, "Duplicate Schedule");
        }

        return busScheduleRepository.save(busSchedule);
    }

    @Override
    public List<BusSchedule> getAllBusSchedules() {
        return busScheduleRepository.findAll();
    }

    @Override
    public List<BusSchedule> getSchedulesByRoute(String routeName) {
        final BusRoute busRoute = busRouteRepository.findByRouteName(routeName)
                .orElseThrow(() -> new ReservationAPIException(HttpStatus.BAD_REQUEST, "Not found"));
        return busScheduleRepository.findByBusRoute(busRoute)
                .orElseThrow(() -> new ReservationAPIException(HttpStatus.BAD_REQUEST, "Not found"));

    }

}
