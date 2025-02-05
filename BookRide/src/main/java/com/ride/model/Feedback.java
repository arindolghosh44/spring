package com.ride.model;





import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int f_id;

    // Add reference to UserDtls
    @ManyToOne(fetch = FetchType.LAZY)  // LAZY loading, can use EAGER based on requirement
    @JoinColumn(name = "user_id")  // Name of the foreign key column in the Feedback table
    private UserDtls user;

    @Column(length = 500)
    private String fullName;

    @Column(length = 500)
    private String description;

    private int rating;

	private String email;
}
