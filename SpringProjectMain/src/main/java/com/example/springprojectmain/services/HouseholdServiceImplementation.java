package com.example.springprojectmain.services;
import com.example.springprojectmain.daos.HouseholdRepository;
import com.example.springprojectmain.entities.Household;
import com.example.springprojectmain.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


public class HouseholdServiceImplementation implements HouseholdService {
    private HouseholdRepository householdRepository;

    @Override
    public Household CreateHousehold(Household household) {
        return householdRepository.save(household);
    }

    @Override
    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    @Override
    public Household findHouseholdByEircode(String eircode) throws NotFoundException {
        return householdRepository.findByEircode(eircode).orElseThrow(
                () -> new NotFoundException("Household not found Eircode: " + eircode));
    }

    @Override
    public Household updateHousehold(Household household) {
        return householdRepository.save(household);
    }

    @Override
    public void deleteHousehold(int id) {
        householdRepository.deleteHousehold(id);
    }

    @Override
    public void deleteHouseholdByEircode(String eircode) {
        householdRepository.deleteHouseholdByEircode(eircode);
    }

    @Override
    public Optional<Household> findHouseholdWithoutPets() {
        return householdRepository.findHouseholdNoPets();
    }

    @Override
    public Optional<Household> findHouseholdOwnerOccupied() {
        return householdRepository.findbyHouseholdOwnerOccupied();
    }

    @Override
    public Object[] getHouseholdStatistics() {
        return new Object[0];
    }


    public void GetHouseholdStatistics() {
        List<Household> households = getAllHouseholds();
        int noOccupants = 0;
        int maxOccupants = 0;
        for (Household household : households) {
            if (household.getNumberOfOccupants() == 0)
                noOccupants++;
            if (household.getNumberOfOccupants() == maxOccupants)
                maxOccupants++;
        }
        System.out.println("Number of households with no Occupants: " + noOccupants);
        System.out.println("Number of households with max Occupants: " + maxOccupants);
    }
}
