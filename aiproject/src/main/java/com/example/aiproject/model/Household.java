package com.example.aiproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "household")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Household {

    @Id
    @Column(name = "eircode", nullable = false)
    private String eircode;

    @Column(name = "number_occupants", nullable = false)
    private int numberOccupants;

    @Column(name = "max_number_occupants", nullable = false)
    private int maxNumberOccupants;

    @Column(name = "owner_occupied", nullable = false)
    private boolean ownerOccupied;

    // One-to-Many relationship with Pet
    @OneToMany(mappedBy = "household", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pet> pets; // May be null if no pets are associated with this household
}