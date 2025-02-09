package com.ride.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reserved")
public class Reserved {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String plateId;

    @Column(length = 500)
    private String model;

    @Column(length = 500)
    private String make;

    private String year;
    private String category;
    private Double price;
    private int stock;
    private int discount;
    private Double discountPrice;
    private Boolean isActive;
    private String pickupDate;
    private String returnDate;
}