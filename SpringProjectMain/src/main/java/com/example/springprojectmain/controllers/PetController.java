package com.example.springprojectmain.controllers;


import com.example.springprojectmain.daos.dtos.PetDto;
import com.example.springprojectmain.entities.Household;
import com.example.springprojectmain.entities.Pet;
import com.example.springprojectmain.services.HouseholdService;
import com.example.springprojectmain.services.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {
    private PetService petService;



    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetByID(@PathVariable Long id) {
        return ResponseEntity.ok(petService.getPetById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Pet> createPet(@Valid @RequestBody PetDto PetDto) {
        Pet pet = new Pet(
                null,
                PetDto.name(),
                PetDto.animalType(),
                PetDto.breed(),
                PetDto.age(),
                null // household can be set later when linking pets to households
        );
        return ResponseEntity.ok(petService.updatePet(pet));
    }

    @PatchMapping("/{id}/name")
    public ResponseEntity<Pet> changePetName(@PathVariable Long id, @Valid @RequestBody String newName) {
        Pet updatedPet = petService.changePetName(id, newName);
        return ResponseEntity.ok(updatedPet);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deletePet(@PathVariable int id) {
        petService.deletePetById(id);
        return ResponseEntity.noContent().build();
    }
}

