package com.pluralsight.deli;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileManager {
    public static void writeOrderToReceipt(Sandwich sandwich) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("receipt.txt"))) {
            writer.write("Order Details:");
            writer.newLine();
            writer.write("Size: " + sandwich.getSize());
            writer.newLine();
            writer.write("Bread: " + sandwich.getBread());
            writer.newLine();
            writer.write("Toasted: " + sandwich.isToasted());
            writer.newLine();
            writer.write("Regular Toppings: " + sandwich.getToppings());
            writer.newLine();
            writer.write("Meat: " + sandwich.getMeat());
            writer.newLine();
            writer.write("Cheese: " + sandwich.getCheese());
            writer.newLine();
            writer.write("Extra Meat: " + sandwich.isExtraMeat());
            writer.newLine();
            writer.write("Extra Cheese: " + sandwich.isExtraCheese());
            writer.newLine();
            writer.write("Sauces: " + sandwich.getSauces());
            writer.newLine();

//            // If chips were added to the order, write the details
//            if (OrderScreen.hasChips()) {
//                writer.write("Chips: " + Chip.getFlavor());
//                writer.newLine();
//            }
//
//            // If drinks were added to the order, write the details
//            if (OrderScreen.hasDrinks()) {
//                Drink drink = sandwich.getDrink();
//                writer.write("Drink: " + drink.getFlavor() + " (Size: " + drink.getSize() + ")");
//                writer.newLine();
//            }

            System.out.println("Order details written to receipt.txt successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to receipt file: " + e.getMessage());
        }
    }

    public static List<String> loadReceipt(){
        List<String> previousOrders = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("receipt.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                previousOrders.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading previous orders: " + e.getMessage());
        }

        return previousOrders;
    }
}