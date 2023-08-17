package com.kkeb.bus_ticket_flutter.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private int errorCode;

    private String errorMessage, devErrorMessage;

    private Long timeStamp;
}
