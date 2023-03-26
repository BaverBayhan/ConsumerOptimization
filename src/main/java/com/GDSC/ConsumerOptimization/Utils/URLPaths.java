package com.GDSC.ConsumerOptimization.Utils;

public enum URLPaths {
    DISHWASHER("Dishwasher"),
    WASHINGMACHINE("WashingMachine"),
    ENERGYCONSUMPTION("EnergyConsumption"),
    VACUUMCLEANER("VacuumCleaner"),
    RUBBISH("Rubbish"),
    PERSONALHYGIENE("PersonalHygiene"),
    KITCHEN("Kitchen"),
    GENERIC("Generic");


    private final String path;

    URLPaths(String path)
    {
        this.path=path;
    }
    public String getPath() {
        return path;
    }
}
