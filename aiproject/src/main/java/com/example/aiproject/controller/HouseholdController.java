package com.example.aiproject.controller;

import com.example.aiproject.DTO.HouseholdDTO;
import com.example.aiproject.model.Household;
import com.example.aiproject.service.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/households")
public class HouseholdController {

    private final HouseholdService householdService;

    @Autowired
    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @GetMapping
    public ResponseEntity<List<Household>> getAllHouseholds() {
        return ResponseEntity.ok(householdService.getAllHouseholds());
    }

    @GetMapping("/{eircode}")
    public ResponseEntity<Household> getHousehold(@PathVariable String eircode) {
        return ResponseEntity.ok(householdService.getHouseholdByEircode(eircode).orElse(null));
    }

    @GetMapping("/no-pets")
    public ResponseEntity<List<Household>> getHouseholdsWithNoPets() {
        return ResponseEntity.ok(householdService.findHouseholdsWithNoPets());
    }

    @GetMapping("/owner-occupied")
    public ResponseEntity<List<Household>> getOwnerOccupied() {
        return ResponseEntity.ok(householdService.findOwnerOccupiedHouseholds());
    }

    @PostMapping
    public ResponseEntity<Household> createHousehold(@Valid @RequestBody HouseholdDTO householdDTO) {
        Household household = new Household(
                householdDTO.eircode(),
                householdDTO.numberOccupants(),
                householdDTO.maxNumberOccupants(),
                householdDTO.ownerOccupied(),
                null // pets can be null initially
        );
        return ResponseEntity.ok(householdService.saveHousehold(household));
    }

    @PutMapping("/{eircode}")
    public ResponseEntity<Household> updateHousehold(@PathVariable String eircode, @Valid @RequestBody HouseholdDTO updatedData) {
        Optional<Household> existing = householdService.getHouseholdByEircode(eircode);
        if (existing.isPresent()) {
            existing.get().setNumberOccupants(updatedData.numberOccupants());
            existing.get().setMaxNumberOccupants(updatedData.maxNumberOccupants());
            existing.get().setOwnerOccupied(updatedData.ownerOccupied());
            return ResponseEntity.ok(householdService.saveHousehold(existing.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{eircode}")
    public ResponseEntity<Void> deleteHousehold(@PathVariable String eircode) {
        householdService.deleteHousehold(eircode);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/statistics")
    public ResponseEntity<Object[]> getStatistics() {
        return ResponseEntity.ok(householdService.getHouseholdStatistics());
    }
}