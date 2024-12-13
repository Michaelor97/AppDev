package com.example.aiproject.service;

import com.example.aiproject.DTO.PetNameAndBreed;
import com.example.aiproject.model.Pet;
import com.example.aiproject.repository.PetRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PetService {

        List<Pet> getAllPets();
        Optional<Pet> getPetById(Long id);
        Pet savePet(Pet pet);
        void deletePet(Long id);

        // New methods
        void deletePetsByName(String name);
        List<Pet> findPetsByAnimalType(String animalType);
        List<Pet> findPetsByBreed(String breed);
        List<PetNameAndBreed> getNameAndBreed();
        Object[] getPetStatistics();

        Pet createPet(Pet pet);

        Pet changePetName(Long id, @Valid String newName);
}
