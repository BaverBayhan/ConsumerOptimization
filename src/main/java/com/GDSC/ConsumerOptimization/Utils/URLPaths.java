package com.GDSC.ConsumerOptimization.Utils;

import com.GDSC.ConsumerOptimization.Entity.Post.PostCategory;

import java.util.Objects;

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

    public static String detectPath(String category)
    {
        if(category.equals(PostCategory.WASHING_MACHINE.getName()))
        {
            return WASHINGMACHINE.getPath();
        }
        else if(category.equals(PostCategory.DISHWASHER.getName()))
        {
            return DISHWASHER.getPath();
        }
        else if(category.equals(PostCategory.ENERGY_CONSUMPTION.getName()))
        {
            return ENERGYCONSUMPTION.getPath();
        }
        else if(category.equals(PostCategory.VACUUM_CLEANER.getName()))
        {
            return VACUUMCLEANER.getPath();
        }
        else if(category.equals(PostCategory.RUBBISH.getName()))
        {
            return RUBBISH.getPath();
        }
        else if(category.equals(PostCategory.PERSONAL_HYGIENE.getName()))
        {
            return PERSONALHYGIENE.getPath();
        }
        else if(category.equals(PostCategory.KITCHEN.getName()))
        {
            return KITCHEN.getPath();
        }
        else return null;
    }
}
