package com.GDSC.ConsumerOptimization.Entity.Post.Subcategories.FormContentIndexes;

public enum KitchenIndexes {

    AVERAGECOOKPERWEEK(1),
    OVENUSAGEPERWEEK(2),
    STOVEUSAGEPERWEEK(3),
    BRANDOFOVEN(4),
    BRANDOFREFRIGERATOR(5);

    private final int index;

    KitchenIndexes(int index) {
        this.index = index;
    }

    public int getName() {
        return index;
    }

}
