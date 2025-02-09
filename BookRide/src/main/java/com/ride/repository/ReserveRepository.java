package com.ride.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import com.ride.model.Reserved;


public interface ReserveRepository  extends JpaRepository <Reserved, Integer>{
	

}
