package com.pluralsight.deli;

import java.util.List;

public class Sandwich implements GetPrice{

    // Fields to represent the attributes of a sandwich
    private int size;
    private String bread;
    private List<String> toppings;
    private boolean toasted;
    private boolean extraMeat;
    private boolean extraCheese;

    // Constructor to initialize a sandwich with its attributes
    public Sandwich(int size, String bread, List<String> toppings, boolean toasted, boolean extraMeat, boolean extraCheese) {
        this.size = size;
        this.bread = bread;
        this.toppings = toppings;
        this.toasted = toasted;
        this.extraMeat = extraMeat;
        this.extraCheese = extraCheese;
    }

    // Getter methods to retrieve the values of the attributes


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    // Method to calculate the price of the sandwich
    @Override
    public double getPrice() {
        // Implement logic to calculate the price of the sandwich based on its attributes
        // You can add more detailed pricing logic depending on the size, toppings, etc.
        // Change return value as needed.
        return 0;
    }

    // Additional methods and functionality can be added as needed
}