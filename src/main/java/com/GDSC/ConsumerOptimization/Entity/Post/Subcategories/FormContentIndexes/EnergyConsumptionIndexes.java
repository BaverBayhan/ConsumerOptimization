package com.GDSC.ConsumerOptimization.Entity.Post.Subcategories.FormContentIndexes;

public enum EnergyConsumptionIndexes {
    ELECTRICITYUSAGE(1),
    NATURALGASUSAGE(2),
    WATERUSAGE(3),
    PUBLICTRANSPORTOROWNVEHICHLE(4),
    KMDRIVEPERMONTH(5),
    TYPEOFFUEL(6),
    PUBLICTRANSPORT(7),
    USAGEFREQUENCYOFPUBLICTRANSPORT(8);



    private final int index;

    EnergyConsumptionIndexes(int index) {
        this.index = index;
    }

    public int getName() {
        return index;
    }
}
