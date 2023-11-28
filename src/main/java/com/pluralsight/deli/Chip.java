package com.pluralsight.deli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Concrete class representing chips
public class Chip implements GetPrice {
    // Attributes for chips
    private String name; // or 'flavor' depending on your preference
    private static final List<String> availableFlavors = new ArrayList<>(Arrays.asList("sea salt", "barbecue", "sour cream & onion")); // ArrayList to store available chip flavors
    private final double additionalPrice = 1.5; // Final price for adding chips

    // Constructor for chips
    public Chip(String name) {
        if (!availableFlavors.contains(name)) {
            throw new IllegalArgumentException("Invalid chip flavor: " + name);
        }
        this.name = name;
    }

    // Concrete implementation of the abstract method from the interface
    @Override
    public double getPrice() {
        // Return the final price for adding chips
        return additionalPrice;
    }

    // Getter method for the chip flavor attribute
    public String getFlavor() {
        return name;
    }

    // Getter method for the available chip flavors
    public static List<String> getAvailableFlavors() {
        return new ArrayList<>(availableFlavors); // Return a copy to prevent modification of the original list
    }

    // add more methods needed for chip class
}
