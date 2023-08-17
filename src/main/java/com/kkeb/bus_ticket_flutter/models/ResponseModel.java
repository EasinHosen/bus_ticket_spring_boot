package com.kkeb.bus_ticket_flutter.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel<T> {

    private int statusCode;

    private String message;

    private T response;
}
