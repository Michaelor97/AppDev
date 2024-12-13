package com.example.aiproject.repository;

import com.example.aiproject.DTO.PetNameAndBreed;
import com.example.aiproject.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    // Find pets by animal type
    List<Pet> findByAnimalTypeIgnoreCase(String animalType);

    // Find pets by breed, ordered by age
    List<Pet> findByBreedOrderByAge(String breed);

    // Delete pets by name ignoring case
    void deleteByNameIgnoreCase(String name);

    // Get name and breed only
    @Query("SELECT new com.example.aiproject.DTO.PetNameAndBreed(p.name, p.animalType, p.breed) FROM Pet p")
    List<PetNameAndBreed> findNameAndBreed();

    // Custom query for statistics
    @Query("SELECT AVG(p.age), MAX(p.age), COUNT(p) FROM Pet p")
    Object[] getPetStatistics();
}