package com.kkeb.bus_ticket_flutter.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busId;
    
    private String busName;
    private String busType;
    private Integer totalSeat;
    @Column(unique = true)
    private String busNumber;

}
