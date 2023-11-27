package com.pluralsight.deli;

// Concrete class representing chips
public class Chip implements GetPrice {
    // Attributes for chips
    private String name; // or 'flavour' depending on your preference
    private final double additionalPrice = 1.5; // Final price for adding chips

    // Constructor for chips
    public Chip(String name) {
        this.name = name;
    }

    // Concrete implementation of the abstract method from the interface
    @Override
    public double getPrice() {
        // Return the final price for adding chips
        return additionalPrice;
    }

    // Getter method for the name attribute
    public String getName() {
        return name;
    }

    // Additional methods specific to chips, if any
}
