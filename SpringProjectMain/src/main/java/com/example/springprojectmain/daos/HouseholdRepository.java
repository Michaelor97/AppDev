package com.example.springprojectmain.daos;
import com.example.springprojectmain.entities.Household;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HouseholdRepository {


    Optional<Household> findByEircode(String Eircode);

    @EntityGraph(attributePaths = {"pets"})
    Optional<Household> findbyEircodeEagarly(String Eircode);

    @Query("SELECT h From Household h WHERE h.pets IS empty ")
    Optional<Household> findHouseholdNoPets();

    void deleteHouseholdByEircode(String eircode);

    @Query("select h From Household h where h.ownerOccupied is false")
    Optional<Household> findbyHouseholdOwnerOccupied();

    void deleteHousehold(int id);

    List<Household> findAll();

    Household save(Household household);
}
