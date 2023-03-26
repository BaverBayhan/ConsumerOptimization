package com.GDSC.ConsumerOptimization.Entity.Post.Subcategories.FormContentIndexes;

public enum WashingMachineIndexes {
    BYHANDORBYMACHINE(1),
    SOLIDITYRATIO(2),
    DOINGLAUNDRYPERWEEK(3),
    TYPEOFDETERGENT(4),
    MLOFDETERGENTPERLAUNDRY(5),
    BRANDOFDETERGENT(6),
    DEGREEOFWASHING(7),
    FABRICSOFTENERUSAGE(8),
    AVERAGECONSUMPTOINOFFABRICSOFTENER(9),
    BRANDOFFABRICSOFTENER(10),
    BRANDOFWASHINGMACHINE(11),
    DRYINGMACHINEUSAGE(12),
    DRYINGMACHINEUSAGEPERWEEK(13),
    BRANDOFDRYINGMACHINE(14);

    private final int index;
    WashingMachineIndexes(int index) {
        this.index = index;
    }
    public int getName() {
        return index;
    }
}
