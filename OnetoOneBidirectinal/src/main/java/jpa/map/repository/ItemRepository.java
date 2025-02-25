package jpa.map.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jpa.map.model.Item;
public interface ItemRepository extends JpaRepository<Item, Long> {
	
}