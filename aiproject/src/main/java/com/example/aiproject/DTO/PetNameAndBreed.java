package com.example.aiproject.DTO;

public class PetNameAndBreed {
    private String name;
    private String animalType;
    private String breed;

    public PetNameAndBreed(String name, String animalType, String breed) {
        this.name = name;
        this.animalType = animalType;
        this.breed = breed;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getBreed() {
        return breed;
    }
}
