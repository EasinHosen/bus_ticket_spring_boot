package com.kkeb.bus_ticket_flutter.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kkeb.bus_ticket_flutter.entities.Bus;
import com.kkeb.bus_ticket_flutter.entities.BusRoute;
import com.kkeb.bus_ticket_flutter.entities.BusSchedule;

public interface BusScheduleRepository extends JpaRepository<BusSchedule, Long >{

    Optional<List<BusSchedule>> findByBusRoute(BusRoute busRoute);

    Boolean existsByBusAndBusRouteAndDepartureTime( Bus bus, BusRoute busRoute, String date);


    
}
