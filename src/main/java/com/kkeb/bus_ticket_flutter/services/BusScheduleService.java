package com.kkeb.bus_ticket_flutter.services;


import java.util.List;

import com.kkeb.bus_ticket_flutter.entities.BusSchedule;

public interface BusScheduleService {
    BusSchedule addSchedule(BusSchedule busSchedule);

    List<BusSchedule> getAllBusSchedules();
    
    List<BusSchedule> getSchedulesByRoute(String routeName);

}
