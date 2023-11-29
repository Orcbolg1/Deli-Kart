package com.pluralsight.deli;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileManager {
    public static void writeOrderToReceipt(Sandwich sandwich) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("receipt.txt"))) {
            OrderScreen orderScreen = new OrderScreen();

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
            //writer.write("Total Price: $" +

            System.out.println("Thank You Come Again!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
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
            System.out.println("Error loading receipts!: " + e.getMessage());
        }

        return previousOrders;
    }
}