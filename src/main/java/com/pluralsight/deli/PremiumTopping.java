package com.pluralsight.deli;

// Concrete subclass representing a premium topping
public class PremiumTopping extends Topping {
    // Constructor for a premium topping
    public PremiumTopping(String name) {
        super(name);
        // Additional initialization for premium topping, if needed
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
        return toppingPrice;
    }

    // Additional methods specific to premium topping, if any

}
