package com.pluralsight.deli;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderScreen {
    public Sandwich createSandwich() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Build your Sandwich");
        barrier('=');

        int size = getBreadSize();
        String bread = getBread();
        List<String> regularTopping = getRegularToppings();
        String meat = getMeatTopping();
        String cheese = getCheeseTopping();
        boolean extraMeat = isExtraMeat();
        boolean extraCheese = isExtraCheese();
        List<String> sides = getSauceChoices();

        // Build the sandwich
        Sandwich sandwich = new Sandwich(size, bread, regularTopping, false, extraMeat, extraCheese);
        sandwich.setMeat(meat);
        sandwich.setCheese(cheese);
        // Add sauces to the sandwich, assuming the Sandwich class has a method to set sauces
        sandwich.setSauces(sides);

        // Ask if the user wants to add chips
        System.out.println("Do you want to add chips to your order? (yes/no): ");
        String addChipsChoice = scanner.next().toLowerCase();
        if (addChipsChoice.equals("yes")) {
            addChipsToOrder();
        }

        // Ask if the user wants to add drinks
        System.out.println("Do you want to add drinks to your order? (yes/no): ");
        String addDrinksChoice = scanner.next().toLowerCase();
        if (addDrinksChoice.equals("yes")) {
            addDrinksToOrder();
        }

        // Print out the order details
        System.out.println("Order Details:");
        System.out.println("Size: " + size);
        System.out.println("Bread: " + bread);
        System.out.println("Regular Toppings: " + regularTopping);
        System.out.println("Meat: " + meat);
        System.out.println("Cheese: " + cheese);
        System.out.println("Extra Meat: " + extraMeat);
        System.out.println("Extra Cheese: " + extraCheese);
        System.out.println("Sauces: " + sides);

        return sandwich;
    }
}