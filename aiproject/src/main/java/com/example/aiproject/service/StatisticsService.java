package com.example.aiproject.service;

import com.example.aiproject.model.Statistics;
import com.example.aiproject.repository.PetRepository;
import com.example.aiproject.repository.HouseholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    private final PetRepository petRepository;
    private final HouseholdRepository householdRepository;

    @Autowired
    public StatisticsService(PetRepository petRepository, HouseholdRepository householdRepository) {
        this.petRepository = petRepository;
        this.householdRepository = householdRepository;
    }

    public Statistics generateStatistics() {
        Statistics stats = new Statistics();
        stats.setTotalPets(petRepository.count());
        stats.setTotalHouseholds(householdRepository.count());
        stats.setEmptyHouseholds(householdRepository.countEmptyHouses()); // originally  householdRepository.countByNumberOccupants(0)
        stats.setFullHouseholds(householdRepository.countFullHouses());  // originally   householdRepository.countByNumberOccupantsEqualsMaxNumberOccupants()
        return stats;
    }
}
