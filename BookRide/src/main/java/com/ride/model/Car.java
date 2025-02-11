package com.ride.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String plateId;

    @Column(length = 500)
    private String model;

    @Column(length = 500)
    private String make;

    private String year;

    private String category;

    private Double price;

    private int stock;

    private String image;

    private int discount;

    private Double discountPrice;

    private Boolean isActive;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reserved> reservations; // Fixed relationship (List instead of single object)
}
