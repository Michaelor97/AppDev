package com.example.springprojectmain.daos.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HouseholdDto (
        @NotBlank(message = "Eircode is mandatory") String eircode,
    @NotNull(message = "Number of occupants is mandatory") Integer numberOccupants,
    @NotNull(message = "Maximum number of occupants is mandatory") Integer maxNumberOccupants,
    @NotNull(message = "Owner occupied status is mandatory") Boolean ownerOccupied
){}
