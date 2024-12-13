package com.example.aiproject.service;

import com.example.aiproject.DTO.PetNameAndBreed;
import com.example.aiproject.exceptions.BadDataException;
import com.example.aiproject.exceptions.PetNotFoundException;
import com.example.aiproject.model.Pet;
import com.example.aiproject.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Optional<Pet> getPetById(Long id) {
        return Optional.ofNullable(petRepository.findById(id).orElseThrow(() ->
                new PetNotFoundException("Pet not found with ID: " + id)));
    }

    @Override
    public Pet savePet(Pet pet) {
        if (pet.getName() == null || pet.getAnimalType() == null) {
            throw new BadDataException("Pet name and animal type cannot be null");
        }
        return petRepository.save(pet);
    }

    @Override
    public void deletePet(Long id) {
        if (!petRepository.existsById(id)) {
            throw new PetNotFoundException("Pet not found with ID: " + id);
        }
        petRepository.deleteById(id);
    }

    @Override
    public void deletePetsByName(String name) {
        petRepository.deleteByNameIgnoreCase(name);
    }

    @Override
    public List<Pet> findPetsByAnimalType(String animalType) {
        return petRepository.findByAnimalTypeIgnoreCase(animalType);
    }

    @Override
    public List<Pet> findPetsByBreed(String breed) {
        return petRepository.findByBreedOrderByAge(breed);
    }

    @Override
    public List<PetNameAndBreed> getNameAndBreed() {
        return petRepository.findNameAndBreed();
    }

    @Override
    public Object[] getPetStatistics() {
        return petRepository.getPetStatistics();
    }

    @Override
    public Pet createPet(Pet pet) {
        return null;
    }

    @Override
    public Pet changePetName(Long id, String newName) {
        return null;
    }
}