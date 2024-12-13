package com.example.springprojectmain.controllers;

import com.example.springprojectmain.entities.Household;
import com.example.springprojectmain.entities.Pet;
import com.example.springprojectmain.services.HouseholdService;
import com.example.springprojectmain.services.PetService;
import com.example.springprojectmain.services.exceptions.BadDataException;
import com.example.springprojectmain.services.exceptions.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.List;
import java.util.Optional;

public class GraphQLController {
    private PetService petService;
    private HouseholdService householdService;

    @QueryMapping
    List<Household> findAllHouseHold() { return householdService.getAllHouseholds();}

    @QueryMapping
    Optional<Pet> findPetsByAnimalType(@Argument String animalType) throws NotFoundException {
        return petService.findAllPetByAnimalType(animalType);
    }

    @QueryMapping
    Pet findPetByID(@Argument long id) throws NotFoundException {
        return petService.getPetById(id);
    }

    @QueryMapping
    Household findHouseholdByEircode(@Argument String eircode) throws NotFoundException {
        return householdService.findHouseholdByEircode(eircode);
    }

    @QueryMapping
    List<Integer> GetPetStatistics(){
        return petService.GetPetStatistics();
    }

    @MutationMapping
    Household createHousehold(@Valid @Argument("household") Household newHousehold) throws BadDataException, NotFoundException {
        Household household = new Household(newHousehold.getEircode(), newHousehold.getNumberOfOccupants(), newHousehold.getMaxNumberOfOccupants(), newHousehold.getOwnerOccupied());
        return householdService.CreateHousehold(household);
    }

    @MutationMapping
    int deleteHousehold(@Argument String eircode) throws NotFoundException {
        householdService.deleteHouseholdByEircode(eircode);
        return 1;
    }

    @MutationMapping
    int deletePet(@Argument int id) throws NotFoundException {
        petService.deletePetById(id);
        return 1;
    }
}
