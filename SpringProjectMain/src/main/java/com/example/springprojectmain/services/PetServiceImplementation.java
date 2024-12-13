package com.example.springprojectmain.services;


import com.example.springprojectmain.daos.HouseholdRepository;
import com.example.springprojectmain.daos.PetRepository;
import com.example.springprojectmain.entities.Household;
import com.example.springprojectmain.entities.Pet;
import com.example.springprojectmain.services.exceptions.NotFoundException;
import org.springframework.transaction.annotation.Transactional;
import com.example.springprojectmain.services.exceptions.BadDataException;

import java.util.List;


public class PetServiceImplementation implements PetService {
    private PetRepository petRepository;

    private HouseholdRepository householdRepository;

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(int id) throws NotFoundException {
        return petRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Pet not found ID: " + id)
        );
    }
    @Override
    public List<Pet> getAllPetsByType(String type) {
        return petRepository.findAllByType(type);
    }
    @Override
    public List<Pet> getAllPetsByBreed(String breed) {
        return petRepository.findAllByBreedOrderByAgeAsc(breed);
    }

    @Transactional
    @Override
    public Pet createPet(Pet pet) throws BadDataException {
        if (pet.getName().isBlank() || pet.getAnimalType().isBlank() || pet.getBreed().isBlank()) {
            throw new BadDataException("Check the name, type and  breed of the Pet.");
        }
        if (pet.getAge() > 0)
            throw new BadDataException("The year cannot be in the future.");
        // Add many more checks in the service before saving the hero
        return petRepository.save(pet);
    }

    @Transactional
    @Override
    public Pet updatePet(Pet petDetails) {
        // Check if the pet exists
        Pet existingPet = petRepository.findById(id).orElseThrow(() -> new NotFoundException("Pet not found with id: " + id));
        // Update the existing pet's details
        existingPet.setName(petDetails.getName());
        existingPet.setAge(petDetails.getAge());
        return petRepository.updatePet(existingPet);
    }

    @Transactional
    @Override
    public void deletePetById(int id) throws NotFoundException {
        int rowsAffected = petRepository.deleteById(id);
        if (rowsAffected != 1) {
            throw new NotFoundException("Pet not found ID: " + id);
        }
    }

    @Override
    public void deletePetsByName(String name) throws NotFoundException {
        if (petRepository.deleteAllPetsByName(name.toUpperCase()) == 0)
            throw new NotFoundException("No pets found with name " + name);
    }

    public Pet addPetToHousehold(Pet pet, String eircode) {
        Household household = householdRepository.findByEircode(eircode)
                .orElseThrow(() -> new RuntimeException("Household not found"));
        household.addPet(pet);
        return petRepository.save(pet);
    }
    @Override
    public Object[] getPetStatistics() {
        return petRepository.getPetStatistics();
    }


}
