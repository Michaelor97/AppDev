package com.example.aiproject.controller;

import com.example.aiproject.DTO.HouseholdDTO;
import com.example.aiproject.DTO.PetDTO;
import com.example.aiproject.model.Household;
import com.example.aiproject.model.Pet;
import com.example.aiproject.service.HouseholdService;
import com.example.aiproject.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLController {
    private final JdbcTemplate jdbcTemplate;

    private final PetService petService;
    private final HouseholdService householdService;

    @Autowired
    public GraphQLController(PetService petService, HouseholdService householdService,JdbcTemplate jdbcTemplate) {
        this.petService = petService;
        this.householdService = householdService;
        this.jdbcTemplate = jdbcTemplate;

    }

    @QueryMapping
    public List<Pet> allPets() {
        return jdbcTemplate.query("SELECT * FROM pet", (rs, rowNum) ->
                new Pet(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("animal_type"),
                        rs.getString("breed"),
                        rs.getInt("age"),
                        null
                )
        );
    }

    @QueryMapping
    public Pet petById(@Argument Long id) {
        return petService.getPetById(id).orElse(null);
    }

    @QueryMapping
    public List<Household> allHouseholds() {
        return householdService.getAllHouseholds();
    }

    @QueryMapping
    public Household householdByEircode(@Argument String eircode) {
        return householdService.getHouseholdByEircode(eircode).orElse(null);
    }

    @QueryMapping
    public List<Household> householdsWithNoPets() {
        return householdService.findHouseholdsWithNoPets();
    }

    @QueryMapping
    public List<Household> ownerOccupiedHouseholds() {
        return householdService.findOwnerOccupiedHouseholds();
    }

    @MutationMapping
    public Pet createPet(@Argument PetDTO input) {
        Pet pet = new Pet(null, input.name(), input.animalType(), input.breed(), input.age(), null);
        return petService.savePet(pet);
    }

    @MutationMapping
    public Household createHousehold(@Argument HouseholdDTO input) {
        Household household = new Household(
                input.eircode(),
                input.numberOccupants(),
                input.maxNumberOccupants(),
                input.ownerOccupied(),
                null
        );
        return householdService.saveHousehold(household);
    }

    @MutationMapping
    public Boolean deletePet(@Argument Long id) {
        petService.deletePet(id);
        return true;
    }

    @MutationMapping
    public Boolean deleteHousehold(@Argument String eircode) {
        householdService.deleteHousehold(eircode);
        return true;
    }
}