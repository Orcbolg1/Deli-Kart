package com.pluralsight.deli;

public class Side {
    public Sauce sideSauce;
    public String auJus;

    public Side(Sauce sideSauce, String auJus) {
        this.sideSauce = sideSauce;
        this.auJus = auJus;
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }
}