package com.pluralsight.deli;

// Concrete subclass representing a regular topping
public class RegularTopping extends Topping {
    // Constructor for a regular topping with a default price of 0.0
    public RegularTopping(String name) {
        super(name);
        // Additional initialization for regular topping, if needed
    }

    // Concrete implementation of the abstract method from the superclass
    @Override
    public String getTopping() {
        return "Regular Topping: " + getName();
    }

    // Override the getPrice method if you want to provide a specific implementation for regular toppings
    @Override
    public double getPrice() {
        // Add any specific logic for calculating the price of the regular topping, if needed
        // For now, just return the price from the superclass
        return super.getPrice();
    }

    // Additional methods specific to regular topping, if any
}
