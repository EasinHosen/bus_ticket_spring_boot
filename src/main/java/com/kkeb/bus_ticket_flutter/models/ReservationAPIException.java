package com.kkeb.bus_ticket_flutter.models;

import org.springframework.http.HttpStatus;

public class ReservationAPIException extends RuntimeException{

    private final HttpStatus status;

    private final String message;

    public ReservationAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    
}
