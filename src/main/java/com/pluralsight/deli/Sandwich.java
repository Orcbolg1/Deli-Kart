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
    private String meat;
    private String cheese;
    private List<String> sauces;

    // Constructor to initialize a sandwich with its attributes
    public Sandwich(int size, String bread, List<String> toppings, boolean toasted, boolean extraMeat, boolean extraCheese) {
        this.size = size;
        this.bread = bread;
        this.toppings = toppings;
        this.toasted = false;
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
        return toasted = true;
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

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public List<String> getSauces() {
        return sauces;
    }

    public void setSauces(List<String> sauces) {
        this.sauces = sauces;
    }

    // Method to calculate the price of the sandwich
    @Override
    public double getPrice() {
        double breadPrice = 0;
        if (getSize() == 4){
            breadPrice += 5.50;
        }
        if (getSize() == 8){
            breadPrice += 7;
        }
        if (getSize() == 12){
            breadPrice += 8.50;
        }
        return breadPrice;
    }

    // Additional methods and functionality can be added as needed
}