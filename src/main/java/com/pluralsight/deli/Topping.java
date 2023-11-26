package com.pluralsight.deli;

// Abstract class representing a topping
public abstract class Topping implements GetPrice{
    // Common attributes for all toppings
    private String name;
    private double price;

    // Constructor for a topping
    public Topping(String name, double price) {
        this.name = name;
        this.price = 0.0; // Default price
    }

    // Getter methods for the attributes
    public String getName() {
        return name;
    }
    @Override
    public double getPrice() {
        return price;
    }

    // Abstract method to be implemented by subclasses
    public abstract String getTopping();

    // Additional methods can be added as needed
}
