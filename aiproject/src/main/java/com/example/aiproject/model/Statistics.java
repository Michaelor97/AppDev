package com.example.aiproject.model;

public class Statistics {
    private long totalPets;
    private long totalHouseholds;
    private long emptyHouseholds;
    private long fullHouseholds;

    public long getTotalPets() {
        return totalPets;
    }

    public void setTotalPets(long totalPets) {
        this.totalPets = totalPets;
    }

    public long getTotalHouseholds() {
        return totalHouseholds;
    }

    public void setTotalHouseholds(long totalHouseholds) {
        this.totalHouseholds = totalHouseholds;
    }

    public long getFullHouseholds() {
        return fullHouseholds;
    }

    public void setFullHouseholds(long fullHouseholds) {
        this.fullHouseholds = fullHouseholds;
    }

    public long getEmptyHouseholds() {
        return emptyHouseholds;
    }

    public void setEmptyHouseholds(long emptyHouseholds) {
        this.emptyHouseholds = emptyHouseholds;
    }
}
