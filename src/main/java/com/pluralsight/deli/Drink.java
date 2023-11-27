package com.pluralsight.deli;

// Concrete class representing a drink
public class Drink implements GetPrice {
    // Attributes for the drink
    private char size; // S for Small, M for Medium, L for Large
    private String flavor;

    // Constructor for a drink
    public Drink(char size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    // Concrete implementation of the abstract method from the interface
    @Override
    public double getPrice() {
        // Add logic to calculate the price based on size and any other factors
        // For simplicity, let's assume a base price and adjust for size
        double basePrice = 2.0; // Base price for a drink

        switch (size) {
            case 'S':
                return basePrice; // Small size
            case 'M':
                return basePrice + .5; // Medium size
            case 'L':
                return basePrice + 1.0; // Large size
            default:
                throw new IllegalArgumentException("Invalid size: " + size);
        }
    }

    // Additional methods specific to the drink, if any
    public char getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }
}
