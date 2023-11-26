package com.pluralsight.deli;


    // I have no idea why this is causing an error.
    public class Sauce extends Topping {
    // Constructor for a sauce topping (default price of 0)
    public Sauce(String name, double price) {
        super(name, price);
    }
    
        @Override
        public double getPrice(){
            return super.getPrice();
    }
}

