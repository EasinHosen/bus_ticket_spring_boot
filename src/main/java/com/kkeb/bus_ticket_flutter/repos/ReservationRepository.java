package com.kkeb.bus_ticket_flutter.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kkeb.bus_ticket_flutter.entities.BusSchedule;
import com.kkeb.bus_ticket_flutter.entities.Customer;
import com.kkeb.bus_ticket_flutter.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
    Optional<List<Reservation>> findByCustomer(Customer customer);
    
    Optional<List<Reservation>> findByBusScheduleAndDepartureDate(BusSchedule busSchedule, String departureDate);

}
