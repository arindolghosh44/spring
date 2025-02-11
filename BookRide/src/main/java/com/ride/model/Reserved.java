package com.ride.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reserved")
public class Reserved {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false)
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserDtls user;

    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean payNow;
    @Column(name = "pickup_date", nullable = false)
    private LocalDate pickupDate;

    @Column(name = "return_date", nullable = false)
    private LocalDate returnDate;

}
