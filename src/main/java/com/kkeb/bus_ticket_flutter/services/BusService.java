package com.kkeb.bus_ticket_flutter.services;

import java.util.List;

import com.kkeb.bus_ticket_flutter.entities.Bus;

public interface BusService {
    
    Bus addBus(Bus bus);

    List<Bus> getAllBus();
}
