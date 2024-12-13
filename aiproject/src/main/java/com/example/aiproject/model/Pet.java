package com.example.aiproject.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// import javax.persistence.*;
@Entity
@Table(name = "pet")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(name = "animal_type", nullable = false, length = 30)
    private String animalType;

    @Column(nullable = false, length = 30)
    private String breed;

    @Column(nullable = false)
    private int age;

    // Many-to-One relationship with Household
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "household_eircode", nullable = false) // Foreign key column
    private Household household; // Each pet must belong to a household
}
