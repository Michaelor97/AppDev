package com.example.aiproject.service;

import com.example.aiproject.model.Household;
import java.util.List;
import java.util.Optional;

public interface HouseholdService {
    List<Household> getAllHouseholds();
    Optional<Household> getHouseholdByEircode(String eircode);
    Household saveHousehold(Household household);
    void deleteHousehold(String eircode);

    // New methods
    Household findHouseholdByEircodeWithPets(String eircode);
    List<Household> findHouseholdsWithNoPets();
    List<Household> findOwnerOccupiedHouseholds();

    // Statistics
    Object[] getHouseholdStatistics(); // Returns an array with counts of empty and full houses
}