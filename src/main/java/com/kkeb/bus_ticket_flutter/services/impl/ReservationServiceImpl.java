package com.kkeb.bus_ticket_flutter.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.kkeb.bus_ticket_flutter.entities.BusSchedule;
import com.kkeb.bus_ticket_flutter.entities.Customer;
import com.kkeb.bus_ticket_flutter.entities.Reservation;
import com.kkeb.bus_ticket_flutter.models.ReservationAPIException;
import com.kkeb.bus_ticket_flutter.repos.BusScheduleRepository;
import com.kkeb.bus_ticket_flutter.repos.CustomerRepository;
import com.kkeb.bus_ticket_flutter.repos.ReservationRepository;
import com.kkeb.bus_ticket_flutter.services.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BusScheduleRepository busScheduleRepository;

    @Override
    public Reservation addReservation(Reservation reservation) {
        final Customer customer;
        final boolean doesCustomerExist = customerRepository
                .existsByMobileOrEmail(reservation.getCustomer().getMobile(), reservation.getCustomer().getEmail());
        if(doesCustomerExist) {
            customer = customerRepository
                    .findByMobileOrEmail(reservation.getCustomer().getMobile(), reservation.getCustomer().getEmail()).orElseThrow();

        } else {
            customer = customerRepository.save(reservation.getCustomer());
        }
        reservation.setCustomer(customer);
        reservation.getTransaction().setCustomerId(customer.getCustomerId());

        // System.out.println(reservation.toString());
        // reservationRepository.save(reservation);
        // System.out.println(reservationRepository.save(reservation));
        
        return reservationRepository.save(reservation);
        
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getReservationsByScheduleAndDepartureDate(Long scheduleId, String departureDate) {
        final BusSchedule schedule = busScheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ReservationAPIException(HttpStatus.BAD_REQUEST, "Reservation not found"));

        return reservationRepository.findByBusScheduleAndDepartureDate(schedule, departureDate)
                .orElseThrow(() -> new ReservationAPIException(HttpStatus.BAD_REQUEST, "Reservation not found"));
    }

    @Override
    public List<Reservation> getReservationsByMobile(String mobile) {
        final Customer customer = customerRepository.findByMobile(mobile)
                .orElseThrow(() -> new ReservationAPIException(HttpStatus.BAD_REQUEST, "Customer not found"));
        return reservationRepository.findByCustomer(customer)
                .orElseThrow(() -> new ReservationAPIException(HttpStatus.BAD_REQUEST, "Reservation not found"));

    }

}
