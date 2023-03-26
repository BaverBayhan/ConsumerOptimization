package com.GDSC.ConsumerOptimization.Entity.Post.Subcategories.FormContentIndexes;

public enum VacuumCleanerIndexes {

    VACUUMCLEANERUSAGEPERWEEK(1),
    SQUAREMETERVACUUM(2),
    BRANDOFVACUUMCLEANER(3),
    ROBOTVACUUMCLEANERUSAGE(4),
    BRANDOFROBOTVACUUMCLEANER(5);

    private final int index;

    VacuumCleanerIndexes(int index) {
        this.index = index;
    }

    public int getName() {
        return index;
    }
}
