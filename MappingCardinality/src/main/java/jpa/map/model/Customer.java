package jpa.map.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	
	
	
	
	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_item")
	@JsonManagedReference*/
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_item", joinColumns = {@JoinColumn(name = "customer_id")},
	inverseJoinColumns = {@JoinColumn(name="item_id")})
	
	private Item item;
}