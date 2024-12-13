package com.example.aiproject.controller;

import com.example.aiproject.DTO.PetDTO;
import com.example.aiproject.model.Pet;
import com.example.aiproject.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable Long id) {
        return ResponseEntity.ok(petService.getPetById(id).orElse(null));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Pet> createPet(@Valid @RequestBody PetDTO petDTO) {
        Pet pet = new Pet(
                null,
                petDTO.name(),
                petDTO.animalType(),
                petDTO.breed(),
                petDTO.age(),
                null // household can be set later when linking pets to households
        );
        return ResponseEntity.ok(petService.savePet(pet));
    }

    @PatchMapping("/{id}/name")
    public ResponseEntity<Pet> changePetName(@PathVariable Long id, @Valid @RequestBody String newName) {
        Pet updatedPet = petService.changePetName(id, newName);
        return ResponseEntity.ok(updatedPet);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return ResponseEntity.noContent().build();
    }
}