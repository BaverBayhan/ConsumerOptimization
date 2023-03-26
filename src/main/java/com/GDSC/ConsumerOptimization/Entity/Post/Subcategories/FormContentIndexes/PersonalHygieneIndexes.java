package com.GDSC.ConsumerOptimization.Entity.Post.Subcategories.FormContentIndexes;

public enum PersonalHygieneIndexes {

    AVERAGESHOWERTIMEPERWEEK(1),
    SHAMPOOCONSUMPTION(2),
    SHOWERGELCONSUMPTION(3),
    TEETHBRUSHPERDAY(4),
    CAREPRODUCTUSAGEPERDAY(5);

    private final int index;

    PersonalHygieneIndexes(int index) {
        this.index = index;
    }

    public int getName() {
        return index;
    }
}
