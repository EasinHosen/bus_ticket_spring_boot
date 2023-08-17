package com.kkeb.bus_ticket_flutter.services;

import java.util.List;

import com.kkeb.bus_ticket_flutter.entities.Reservation;

public interface ReservationService {
    Reservation addReservation(Reservation reservation);

    List<Reservation> getAllReservations();
    
    List<Reservation> getReservationsByScheduleAndDepartureDate(Long scheduleId, String departureDate);
    
    List<Reservation> getReservationsByMobile(String mobile);


}
