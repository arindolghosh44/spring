package com.ride.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ride.model.Car;
import com.ride.model.Reserved;
import com.ride.model.UserDtls;
import com.ride.repository.CarRepository;
import com.ride.repository.ReserveRepository;
import com.ride.service.ReservedService;

@Service
public class ReservedServiceImpl implements ReservedService {
    
    @Autowired
    private ReserveRepository reservedRepository;

    @Autowired
    private CarRepository carRepository;

    @Transactional
    @Override
    public Reserved saveReservation(UserDtls user, Car car, Boolean payNow, String pickupDate, String returnDate) {

        if (car.getStock() <= 0) {
            throw new RuntimeException("Car is out of stock!");
        }

        // Create a new reservation
        Reserved reserved = new Reserved();
        reserved.setUser(user);
        reserved.setCar(car);
        reserved.setPayNow(payNow);

        // Reduce stock
        car.setStock(car.getStock() - 1);
        carRepository.save(car); // Update car stock in DB

        return reservedRepository.save(reserved);
    }
}
