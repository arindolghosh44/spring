package com.arindom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arindom.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

	
}
