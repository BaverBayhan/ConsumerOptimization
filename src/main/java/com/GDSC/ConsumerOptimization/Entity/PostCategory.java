package com.GDSC.ConsumerOptimization.Entity;

public enum PostCategory {
    TV("Television"),
    FRIDGE("Refrigerator"),
    WASHING_MACHINE("Washing Machine"),
    DRYER("Dryer"),
    DISHWASHER("Dishwasher"),
    OVEN("Oven"),
    MICROWAVE("Microwave"),
    TOASTER("Toaster"),
    COFFEE_MAKER("Coffee Maker");

    private final String name;
    PostCategory(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }
}
