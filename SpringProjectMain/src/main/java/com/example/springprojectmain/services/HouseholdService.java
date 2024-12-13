package com.example.springprojectmain.services;

import com.example.springprojectmain.entities.Household;
import com.example.springprojectmain.services.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface HouseholdService {
    Household CreateHousehold(Household household);
    List<Household> getAllHouseholds();
    Household findHouseholdByEircode(String eircode) throws NotFoundException;
    Household updateHousehold(Household household);
    void deleteHousehold(int id);
    void deleteHouseholdByEircode(String eircode);
    Optional<Household> findHouseholdWithoutPets();
    Optional<Household> findHouseholdOwnerOccupied();

    Object[] getHouseholdStatistics();
}
