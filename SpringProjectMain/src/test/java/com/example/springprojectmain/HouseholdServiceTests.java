package com.example.springprojectmain;


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.springprojectmain.entities.Household;
import com.example.springprojectmain.daos.HouseholdRepository;
import com.example.springprojectmain.services.HouseholdService;
import com.example.springprojectmain.services.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@SpringBootTest
@Rollback
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HouseholdServiceTests {
    @Autowired
    HouseholdRepository householdRepository;
    @Autowired
    HouseholdService householdService;

    @Test
    void testCreateHousehold() {
        Household household = new Household("T12AB34", 3, 5, 1);
        when(householdRepository.save(household)).thenReturn(household);
        Household result = householdService.CreateHousehold(household);
        assertNotNull(result);
        assertEquals("T12AB34", result.getEircode());
        assertEquals(3, result.getNumberOfOccupants());
        assertEquals(5, result.getMaxNumberOfOccupants());
        assertEquals(1, result.getOwnerOccupied());
        verify(householdRepository, times(1)).save(household);
    }
    @Test
    void testFindHouseholdByEircode() throws NotFoundException {
        Household household = new Household("T12AB34", 3, 5, 1);
        when(householdRepository.findByEircode("T12AB34")).thenReturn(Optional.of(household));

        Household result = householdService.findHouseholdByEircode("T12AB34");

        assertNotNull(result);
        assertEquals("T12AB34", result.getEircode());
        assertEquals(3, result.getNumberOfOccupants());
        assertEquals(5, result.getMaxNumberOfOccupants());
        assertEquals(1, result.getOwnerOccupied());
    }

    @Test
    void testUpdateHousehold() {
        Household household = new Household("T12AB34", 3, 5, 1);
        when(householdRepository.save(household)).thenReturn(household);

        household.setNumberOfOccupants(4);
        Household result = householdService.updateHousehold(household);

        assertNotNull(result);
        assertEquals(4, result.getNumberOfOccupants());
        verify(householdRepository, times(1)).save(household);
    }

    @Test
    void testDeleteHouseholdByEircode() {
        Household household = new Household("T12AB34", 3, 5, 1);
        when(householdRepository.findByEircode("T12AB34")).thenReturn(Optional.of(household));
        householdService.deleteHouseholdByEircode("T12AB34");
        verify(householdRepository, times(1)).delete(household);
    }

    @Test
    void testFindHouseholdWithoutPets() {
        Household household = new Household("T12AB34", 3, 5, 1);
        when(householdRepository.findHouseholdNoPets()).thenReturn(Optional.of(household));

        Optional<Household> result = householdService.findHouseholdWithoutPets();

        assertTrue(result.isPresent());
        assertEquals("T12AB34", result.get().getEircode());
    }

    @Test
    void testFindHouseholdOwnerOccupied() {
        Household household = new Household("T12AB34", 3, 5, 1);
        when(householdRepository.findbyHouseholdOwnerOccupied()).thenReturn(Optional.of(household));

        Optional<Household> result = householdService.findHouseholdOwnerOccupied();

        assertTrue(result.isPresent());
        assertEquals("T12AB34", result.get().getEircode());
    }

    @Test
    void testGetHouseholdStatistics() {
        // Assuming you have a method that provides statistics, mock the behavior here
        // For example:
        when(householdRepository.count()).thenReturn(10L);

        householdService.GetHouseholdStatistics();

        // You can check if statistics are correctly calculated, for now just verify repository interaction
        verify(householdRepository, times(1)).count();
    }
}