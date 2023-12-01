package com.pluralsight.deli;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class FileManager {
    public static void writeOrderToReceipt(List<Sandwich> sandwich, Chip chip, Drink drink, double price) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("receipt.txt", true))) {
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy-HH:mm:ss");
            String formattedDateTime = dateTime.format(dateTimeFormatter);

            String boughtChip = null;
            if (chip == null){
                boughtChip = "none";
            } else {
                boughtChip = chip.toString();
            }

            String boughtDrink = null;
            if (drink == null){
                boughtDrink = "none";
            } else{
                boughtDrink = drink.toString();
            }
            writer.write("Date and Time: " + formattedDateTime);
            writer.newLine();
            writer.write("Order Details:");
            writer.newLine();
            for (int i = 0; i < sandwich.size(); i++) {
                writer.write("Size: " + sandwich.get(i).getSize() + " inches");
                writer.newLine();
                writer.write("Bread: " + sandwich.get(i).getBread());
                writer.newLine();
                writer.write("Toasted: " + sandwich.get(i).isToasted());
                writer.newLine();
                writer.write("Regular Toppings: " + sandwich.get(i).getToppings());
                writer.newLine();
                writer.write("Meat: " + sandwich.get(i).getMeat());
                writer.newLine();
                writer.write("Cheese: " + sandwich.get(i).getCheese());
                writer.newLine();
                writer.write("Extra Meat: " + sandwich.get(i).isExtraMeat());
                writer.newLine();
                writer.write("Extra Cheese: " + sandwich.get(i).isExtraCheese());
                writer.newLine();
                writer.write("Sauces: " + sandwich.get(i).getSauces());
                writer.newLine();
            }
            writer.write("Chip: " + boughtChip);
            writer.newLine();
            writer.write("Drink: " + boughtDrink);
            writer.newLine();
            writer.write("Total Price: $" + price);
            writer.newLine();
            // added the barrier to the recipt
            writer.write("=======================================================");
            writer.newLine();

            System.out.println("Thank You Come Again!");


            writer.write(OrderScreen.barrier('='));

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static List<String> loadReceipt() {
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