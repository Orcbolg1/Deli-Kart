package com.pluralsight.deli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Concrete subclass representing a premium topping
public class PremiumTopping extends Topping {
    //List of toppings customer can add
    private boolean isExtraMeat;
    private boolean isExtraCheese;
    private static final List<String> meatToppings = new ArrayList<>(Arrays.asList("steak", "ham", "salami", "roast beef",
            "chicken", "bacon"));
    private static final List<String> cheeseToppings = new ArrayList<>(Arrays.asList("american", "provolone", "cheddar", "swiss"));

    // Constructor for a premium topping
    public PremiumTopping(String name) {
        // Additional initialization for premium topping, if needed
        this.isExtraMeat = false;
        this.isExtraCheese = false;
    }

    public boolean isExtraMeat() {
        return isExtraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        isExtraMeat = extraMeat;
    }

    public boolean isExtraCheese() {
        return isExtraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        isExtraCheese = extraCheese;
    }

    public static List<String> getMeatToppings(){
        return new ArrayList<>(meatToppings);
    }

    public static List<String> getCheeseToppings(){
        return new ArrayList<>(cheeseToppings);
    }

    public void giveMeMeat(){
        isExtraMeat = true;
    }

    public void giveMeCheese(){
        isExtraCheese = true;
    }

    // Concrete implementation of the abstract method from the superclass
    @Override
    public String getTopping() {
        return null;
    }

    // Override the getPrice method to add 1 dollar for premium toppings


    }

    // Additional methods specific to premium topping, if any


