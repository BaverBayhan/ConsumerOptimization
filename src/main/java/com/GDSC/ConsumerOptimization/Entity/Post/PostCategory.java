package com.GDSC.ConsumerOptimization.Entity.Post;

import com.GDSC.ConsumerOptimization.Utils.URLPaths;

public enum PostCategory {

    DISHWASHER("Dishwasher"),
    ENERGY_CONSUMPTION("Energy Consumption"),
    GENERIC("Generic"),
    KITCHEN("Kitchen"),
    PERSONAL_HYGIENE("Personal Hygiene"),
    RUBBISH("Rubbish"),
    VACUUM_CLEANER("Vacuum Cleaner"),
    WASHING_MACHINE("Washing Machine");



    private final String name;
    PostCategory(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }


    public static PostCategory checkPostCategory(String category)
    {
        if(category.equals(PostCategory.WASHING_MACHINE.getName()))
        {
            return PostCategory.WASHING_MACHINE;
        }
        else if(category.equals(PostCategory.DISHWASHER.getName()))
        {
            return PostCategory.DISHWASHER;
        }
        else if(category.equals(PostCategory.GENERIC.getName()))
        {
            return PostCategory.GENERIC;
        }
        else if(category.equals(PostCategory.KITCHEN.getName()))
        {
            return PostCategory.KITCHEN;
        }
        else if(category.equals(PostCategory.ENERGY_CONSUMPTION.getName()))
        {
            return PostCategory.ENERGY_CONSUMPTION;
        }
        else if(category.equals(PostCategory.RUBBISH.getName()))
        {
            return PostCategory.RUBBISH;
        }
        else if(category.equals(PostCategory.VACUUM_CLEANER.getName()))
        {
            return PostCategory.VACUUM_CLEANER;
        }
        else if(category.equals(PostCategory.PERSONAL_HYGIENE.getName()))
        {
            return PostCategory.PERSONAL_HYGIENE;
        }

        else return null;
    }
}
