package com.ride.service;

import com.ride.model.Car;
import com.ride.model.Reserved;
import com.ride.model.UserDtls;

public interface ReservedService {
	 Reserved saveReservation(UserDtls user, Car car, Boolean payNow, String pickupDate, String returnDate);
}
