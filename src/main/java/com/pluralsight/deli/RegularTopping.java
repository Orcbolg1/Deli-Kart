package com.pluralsight.deli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Concrete subclass representing a regular topping
public class RegularTopping extends Topping {
    // Constructor for a regular topping with a default price of 0.0
    private static final List<String> regularToppings = new ArrayList<>(Arrays.asList("lettuce", "peppers", "onions",
            "tomatoes", "jalapenos", "cucumbers", "pickles", "guacamole", "mushrooms"));



    // Override the getPrice method if you want to provide a specific implementation for regular toppings
    @Override
    public double getPrice() {
        // Add any specific logic for calculating the price of the regular topping, if needed
        // For now, just return the price from the superclass
        return super.getPrice();
    }

    @Override
    public String getTopping() {
        // Return a copy to prevent modification of the original list
        return String.valueOf(new ArrayList<>(regularToppings));
    }
    // Additional methods specific to regular topping, if any

}
