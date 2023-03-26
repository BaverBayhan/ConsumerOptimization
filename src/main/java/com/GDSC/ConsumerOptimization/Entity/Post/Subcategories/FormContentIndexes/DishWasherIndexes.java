package com.GDSC.ConsumerOptimization.Entity.Post.Subcategories.FormContentIndexes;

public enum DishWasherIndexes {

    BYHANDORBYMACHINE(1),
    AVERAGEDISHWASHPERWEEK1(2),
    SOLIDITYRATIO(3),
    BRANDOFDISHWASHERDETERGENT(4),
    BRANDOFDISHWASHER(5),
    RINSEAIDUSAGE(6),
    RINSEAIDBRAND(7),
    AVERAGEDISHWASHPERWEEK2(8);


    private final int index;

    DishWasherIndexes(int index) {
        this.index = index;
    }

    public int getName() {
        return index;
    }
}
