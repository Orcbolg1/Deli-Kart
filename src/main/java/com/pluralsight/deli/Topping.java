package com.pluralsight.deli;

// Abstract class representing a topping
public abstract class Topping implements GetPrice{
    // Common attributes for all toppings
    private double price;

    // Getter methods for the attributes
    @Override
    public double getPrice() {
        return price;
    }

    // Abstract method to be implemented by subclasses
    public abstract String getTopping();

    // Additional methods can be added as needed
}
