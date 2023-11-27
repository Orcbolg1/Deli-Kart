package com.pluralsight.deli;

import java.util.ArrayList;
import java.util.List;

// Concrete subclass representing a premium topping
public class PremiumTopping extends Topping {
    //List of toppings customer can add
    private boolean isExtraMeat;
    private boolean isExtraCheese;
    private static final List<String> meatToppings = new ArrayList<>();
    static{
        meatToppings.add("Steak");
        meatToppings.add("Ham");
        meatToppings.add("Salami");
        meatToppings.add("Roast Beef");
        meatToppings.add("Chicken");
        meatToppings.add("Bacon");

    }

    private static final List<String> cheeseToppings = new ArrayList<>();
    static{
        cheeseToppings.add("American");
        cheeseToppings.add("Provolone");
        cheeseToppings.add("Cheddar");
        cheeseToppings.add("Swiss");
    }

    // Constructor for a premium topping
    public PremiumTopping(String name) {
        super(name);
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

    // Concrete implementation of the abstract method from the superclass
    @Override
    public String getTopping() {
        return "Premium Topping: " + getName();
    }

    // Override the getPrice method to add 1 dollar for premium toppings


    public double getPrice(Sandwich sandwich) {
        // Add 1 dollar to the base price for premium toppings
        double toppingPrice = 0;
        if (sandwich.getSize() == 4){
            toppingPrice = 1;
        }
        if (sandwich.getSize() == 8){
            toppingPrice = 2;
        }
        if (sandwich.getSize() == 12){
            toppingPrice = 3;
        }

        double extraPrice = 0;
        if (!isExtraMeat){
            if (sandwich.getSize() == 4){
                extraPrice += .50;
            }
            if (sandwich.getSize() == 8){
                extraPrice += 1.00;
            }
            if (sandwich.getSize() == 12){
                extraPrice += 1.50;
            }
        }

        if (!isExtraCheese){
            if (sandwich.getSize() == 4){
                extraPrice += .30;
            }
            if (sandwich.getSize() == 8){
                extraPrice += .60;
            }
            if (sandwich.getSize() == 12){
                extraPrice += .90;
            }
        }
        return toppingPrice + extraPrice;
    }

    // Additional methods specific to premium topping, if any

}
