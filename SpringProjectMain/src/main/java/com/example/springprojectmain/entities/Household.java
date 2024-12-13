package com.example.springprojectmain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@Entity
@Table(name = "HOUSEHOLD")
@AllArgsConstructor
@NoArgsConstructor
public class Household {
    @Id
    private String eircode;
    private int numberOfOccupants;
    private int maxNumberOfOccupants;
    private int ownerOccupied;
    public Household(String eircode, int numberOfOccupants, int maxNumberOfOccupants, int ownerOccupied) {
        this.eircode = eircode;
        this.numberOfOccupants = numberOfOccupants;
        this.maxNumberOfOccupants = maxNumberOfOccupants;
        this.ownerOccupied = ownerOccupied;
    }
    @OneToMany(mappedBy = "household", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Pet> pets;

    public void addPet(Pet pet) {
    }
}