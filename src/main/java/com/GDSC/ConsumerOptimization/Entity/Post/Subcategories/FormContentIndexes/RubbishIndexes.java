package com.GDSC.ConsumerOptimization.Entity.Post.Subcategories.FormContentIndexes;

public enum RubbishIndexes {

    GARBAGEBAGCOUNTPERWEEK(1),
    RECYCLINGORNOT(2),
    RECYCLINGBAGAMOUNTSPERWEEK(3);

    private final int index;

    RubbishIndexes(int index) {
        this.index = index;
    }

    public int getName() {
        return index;
    }
}
