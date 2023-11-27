package com.pluralsight.deli;

// Concrete subclass representing a sauce
public class Sauce extends Topping {
    // Additional attributes specific to sauce, if any

    // Constructor for a sauce
    public Sauce(String name) {
        super(name);
        // Additional initialization for sauce, if needed
    }

    // Concrete implementation of the abstract method from the superclass
    @Override
    public String getTopping() {
        return "Sauce: " + getName();
    }

    // Override the getPrice method if you want to provide a specific implementation for sauces
    @Override
    public double getPrice() {
        // Add any specific logic for calculating the price of the sauce, if needed
        // For now, just return the price from the superclass
        return super.getPrice();
    }
}

