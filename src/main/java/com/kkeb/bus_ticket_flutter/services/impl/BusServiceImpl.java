package com.kkeb.bus_ticket_flutter.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkeb.bus_ticket_flutter.entities.Bus;
import com.kkeb.bus_ticket_flutter.repos.BusRepository;
import com.kkeb.bus_ticket_flutter.services.BusService;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    @Override
    public Bus addBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public List<Bus> getAllBus() {
        return busRepository.findAll();
    }
    
}
