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
    @Override
    public double getPrice() {
        // Add 1 dollar to the base price for premium toppings
        return super.getPrice();
    }

    // Additional methods specific to premium topping, if any
}
