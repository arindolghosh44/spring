package com.ride.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserDtls {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String holderName;
    private String creditCardNo;
    private String expiryDate;
    private String creditCardCvv;
    private String password;
    private String role;
    private String profileImage;
    private Boolean isEnable;
    private Boolean accountNonLocked;
    private Integer failedAttempt;
    private Date lockTime;
    private String resetToken;
    private String confirmationToken;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reserved> reservations; // Fixed relationship
}
