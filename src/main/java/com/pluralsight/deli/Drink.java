package com.pluralsight.deli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Concrete class representing a drink
public class Drink implements GetPrice {
    // Attributes for the drink
    private char size; // S for Small, M for Medium, L for Large
    private String flavor;
    //Arrays.asList takes in an array for the list since it's final anyway. more beginner-developer-friendly to understand
    private static final List<String> availableFlavors = new ArrayList<>(Arrays.asList("cola", "fanta", "sprite",
            "pepsi", "7up")); // ArrayList to store available flavors
    private final double basePrice = 2.0; // Base price for a drink

    // Constructor for a drink
    public Drink(char size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public double getBasePrice() {
        return basePrice;
    }

    // Concrete implementation of the abstract method from the interface
    @Override
    public double getPrice() {
        // Add logic to calculate the price based on size and any other factors
        // For simplicity, let's assume a base price and adjust for size


        switch (size) {
            case 'S':
                return getBasePrice(); // Small size
            case 'M':
                return getBasePrice() + .5; // Medium size
            case 'L':
                return getBasePrice() + 1.0; // Large size
            default:
                throw new IllegalArgumentException("Invalid size: " + size);
        }
    }

    // Getter method for the flavor attribute
    public String getFlavor() {
        return flavor;
    }

    // Getter method for the available flavors
    public static List<String> getAvailableFlavors() {
        return new ArrayList<>(availableFlavors); // Return a copy to prevent modification of the original list
    }

    // Additional methods specific to the drink, if any

    @Override
    public String toString() {
        return "size = " + size +
                ", " + flavor;
    }
}