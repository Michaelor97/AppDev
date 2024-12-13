package com.example.springprojectmain.daos;

import com.example.springprojectmain.daos.dtos.PetDto;
import com.example.springprojectmain.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Integer> {
    Optional<Pet> findByPetId(int id);

    @Query("SELECT p.animalType FROM Pet p WHERE p.animalType=:type")
    List<Pet> findAllByType(@Param("animalType") String type);
    List<Pet> findAll();
    List<Pet> findAllByBreedOrderByAgeAsc(String breed);
    List<Pet> findByHouseholdEircode(String eircode);
    int deleteById(int id);
    int deleteAllPetsByName(String upperCase);

    @Query("SELECT new com.example.springprojectmain.daos.dtos.PetDto(p.name, p.animalType, p.breed) FROM Pet p")
    Optional<PetDto> findPetNameAndBreed();
    @Modifying
    @Transactional
    @Query(value = "UPDATE pets SET name=:newName WHERE pet_id=:id",
            nativeQuery = true)
    void updatePetById(@Param("id") int id, @Param("newName") String newName);
    @Transactional
    @Modifying
    Pet updatePet(Pet pet);


    Object[] getPetStatistics();
}
