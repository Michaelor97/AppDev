package com.example.aiproject.service;

import com.example.aiproject.exceptions.BadDataException;
import com.example.aiproject.exceptions.PetNotFoundException;
import com.example.aiproject.model.Household;
import com.example.aiproject.repository.HouseholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseholdServiceImpl implements HouseholdService {

    private final HouseholdRepository householdRepository;

    @Autowired
    public HouseholdServiceImpl(HouseholdRepository householdRepository) {
        this.householdRepository = householdRepository;
    }

    @Override
    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    @Override
    public Optional<Household> getHouseholdByEircode(String eircode) {
        return householdRepository.findById(eircode);
    }

    @Override
    public Household saveHousehold(Household household) {
        if (household.getEircode() == null || household.getNumberOccupants() < 0 || household.getMaxNumberOccupants() <= 0) {
            throw new BadDataException("Invalid household data");
        }
        return householdRepository.save(household);
    }

    @Override
    public void deleteHousehold(String eircode) {
        if (!householdRepository.existsById(eircode)) {
            throw new PetNotFoundException("Household not found with Eircode: " + eircode);
        }
        // Optionally, you can also delete associated pets here if needed.
        householdRepository.deleteById(eircode);
    }

    @Override
    public Household findHouseholdByEircodeWithPets(String eircode) {
        return householdRepository.findByEircodeWithPets(eircode);
    }

    @Override
    public List<Household> findHouseholdsWithNoPets() {
        return householdRepository.findHouseholdsWithNoPets();
    }

    @Override
    public List<Household> findOwnerOccupiedHouseholds() {
        return householdRepository.findByOwnerOccupiedTrue();
    }

    @Override
    public Object[] getHouseholdStatistics() {
        Long emptyCount = householdRepository.countEmptyHouses();
        Long fullCount = householdRepository.countFullHouses();
        return new Object[]{emptyCount, fullCount}; // Returns an array with counts of empty and full houses.
    }


}
