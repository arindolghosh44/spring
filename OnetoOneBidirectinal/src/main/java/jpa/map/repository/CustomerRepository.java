package jpa.map.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jpa.map.model.Customer;
public interface CustomerRepository extends JpaRepository<Customer, Long> {}
