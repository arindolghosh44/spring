package com.ride.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ride.model.Reserved;
import com.ride.service.ReservedService;
import com.ride.repository.ReserveRepository;

@Service
public class ReservedServiceImpl implements ReservedService {
    
    @Autowired
    private ReserveRepository reservedRepository;

    @Override
    @Transactional // Ensures the operation runs within a single transaction
    public Reserved saveReservation(Reserved reserved) {
        if (reserved == null) {
            throw new IllegalArgumentException("Reserved object cannot be null");
        }

        try {
            return reservedRepository.save(reserved);
        } catch (Exception e) {
            throw new RuntimeException("Error saving reservation: " + e.getMessage(), e);
        }
    }
}
