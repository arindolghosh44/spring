package com.becoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.becoder.model.Cart;


public interface CartRepository extends JpaRepository<Cart, Long>{

}
