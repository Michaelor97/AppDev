package com.example.springprojectmain.controllers;

import com.example.springprojectmain.entities.Household;
import com.example.springprojectmain.services.HouseholdService;
import com.example.springprojectmain.services.PetService;
import com.example.springprojectmain.services.exceptions.NotFoundException;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/households")
public class HouseholdController {

    HouseholdService householdService;

    @GetMapping({"/", ""})
    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    @GetMapping({"/nopet"})
    public Optional<Household> getHouseHoldNoPets(){
        return householdService.findHouseholdWithoutPets();
    }

    @GetMapping({"/{eircode}"})
    public Household getHouseHoldByEircode(@PathVariable String eircode) throws NotFoundException {
        System.out.println(eircode);
        return householdService.findHouseholdByEircode(eircode);
    }

    @DeleteMapping({"/{eircode}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHousehold(@PathVariable String eircode) throws NotFoundException{
        householdService.deleteHouseholdByEircode(eircode);
        System.out.println("Household with eircode: " + eircode + " deleted");
    }

    @PostMapping({"/"})
    @ResponseStatus(HttpStatus.CREATED)
    public Household addHousehold(@RequestBody @Valid Household newHousehold) throws NotFoundException {
        Household household = new Household(newHousehold.getEircode(), newHousehold.getNumberOfOccupants(), newHousehold.getMaxNumberOfOccupants(),
                newHousehold.getOwnerOccupied());
        return householdService.CreateHousehold(household);
    }
}