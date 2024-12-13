package com.example.aiproject.repository;

import com.example.aiproject.model.Household;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseholdRepository extends JpaRepository<Household, String> {

    // Find all households that are owner-occupied
    List<Household> findByOwnerOccupiedTrue();
    @Query("SELECT h FROM Household h LEFT JOIN FETCH h.pets WHERE h.eircode = :eircode")
    Household findByEircodeWithPets(String eircode);

    // Find all households with no pets
    @Query("SELECT h FROM Household h WHERE h.pets IS EMPTY")
    List<Household> findHouseholdsWithNoPets();
    // Statistics query for counting empty and full houses
    @Query("SELECT COUNT(h) FROM Household h WHERE h.numberOccupants = 0")
    Long countEmptyHouses();

    @Query("SELECT COUNT(h) FROM Household h WHERE h.numberOccupants = h.maxNumberOccupants")
    Long countFullHouses();

}
