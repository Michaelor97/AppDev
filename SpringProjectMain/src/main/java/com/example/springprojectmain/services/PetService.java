package com.example.springprojectmain.services;

import com.example.springprojectmain.entities.Pet;
import com.example.springprojectmain.services.exceptions.NotFoundException;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface PetService {
    List<Pet> getAllPets();
    Pet getPetById(long id);
    List<Pet> getAllPetsByType(String type);
    List<Pet> getAllPetsByBreed(String breed);
    Pet createPet(Pet pet);
    Pet updatePet(Pet petDetails);
    void deletePetById(int id);


    void deletePetsByName(String name) throws NotFoundException;

    Pet changePetName(Long id, @Valid String newName);

    List<Integer> GetPetStatistics();

    Optional<Pet> findAllPetByAnimalType(String animalType);
}
