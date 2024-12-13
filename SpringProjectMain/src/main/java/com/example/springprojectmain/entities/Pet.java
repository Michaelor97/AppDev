package com.example.springprojectmain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity    // assumes this class is used in a table , assumes the name of the table is the same as this class 'Hero'
@Table(name = "pets")     // specifies the table
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @Id  //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String animalType;
    private String breed;
    private int age;
    private String eircode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "household_eircode", nullable = false)
    private Household household;


    public Pet(Object o, @NotBlank(message = "Name is mandatory") String name, @NotBlank(message = "Animal type is mandatory") String s, @NotBlank(message = "Breed is mandatory") String breed, @NotNull(message = "Age is mandatory") Integer age, Object o1) {
    }
}