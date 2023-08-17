package com.kkeb.bus_ticket_flutter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.kkeb.bus_ticket_flutter.entities.Reservation;
import com.kkeb.bus_ticket_flutter.models.ResponseModel;
import com.kkeb.bus_ticket_flutter.services.ReservationService;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/add")
    public ResponseModel<Reservation> addReservation(@RequestBody Reservation reservation) {

        final Reservation res = reservationService.addReservation(reservation);
        
        return new ResponseModel<>(HttpStatus.OK.value(), "Reservation saved", res);
    }

    @GetMapping("/all")
    public ResponseModel<List<Reservation>> getAllReservations() {
        return new ResponseModel<List<Reservation>>(HttpStatus.OK.value(), "Reservations fetched successfully",
                reservationService.getAllReservations());
    }

    @GetMapping("/query")
    public ResponseModel<List<Reservation>> getReservationByScheduleAndDepartureDate(
            @RequestParam Long scheduleId,
            @RequestParam String departureDate) {
        return new ResponseModel<List<Reservation>>(HttpStatus.OK.value(), "Fetched successfully",
                reservationService.getReservationsByScheduleAndDepartureDate(scheduleId, departureDate));
    }

    @GetMapping("/all/{mobile}")
    public ResponseModel<List<Reservation>> getReservationByMobile(
            @PathVariable(name = "mobile") String mobile) {
        return new ResponseModel<List<Reservation>>(HttpStatus.OK.value(), "Fetched successfully",
                reservationService.getReservationsByMobile(mobile));
    }

}
