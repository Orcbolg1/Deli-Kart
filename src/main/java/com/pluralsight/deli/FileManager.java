package com.pluralsight.deli;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class FileManager {
    private static final String RECEIPT_DIRECTORY = "Receipts";  // Update directory name
    private static final String RECEIPT_FILE_EXTENSION = ".txt";

    public static void writeOrderToReceipt(List<Sandwich> sandwiches, Chip chip, Drink drink, double price) {
        // Create the receipt directory if it doesn't exist
        File directory = new File(RECEIPT_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Generate a unique receipt file name based on current date and time
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy-HH_mm_ss"); // Use underscores instead of colons
        String formattedDateTime = dateTime.format(dateTimeFormatter);
        String receiptFileName = RECEIPT_DIRECTORY + File.separator + "receipt_" + formattedDateTime + RECEIPT_FILE_EXTENSION;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(receiptFileName))) {
            // Write order details to the receipt file
            writer.write("Date and Time: " + formattedDateTime);
            writer.newLine();
            writer.write("Order Details:");
            writer.newLine();

            for (int i = 0; i < sandwiches.size(); i++) {
                writer.write("Size: " + sandwiches.get(i).getSize() + " inches");
                writer.newLine();
                writer.write("Bread: " + sandwiches.get(i).getBread());
                writer.newLine();
                writer.write("Toasted: " + sandwiches.get(i).isToasted());
                writer.newLine();
                writer.write("Regular Toppings: " + sandwiches.get(i).getToppings());
                writer.newLine();
                writer.write("Meat: " + sandwiches.get(i).getMeat());
                writer.newLine();
                writer.write("Cheese: " + sandwiches.get(i).getCheese());
                writer.newLine();
                writer.write("Extra Meat: " + sandwiches.get(i).isExtraMeat());
                writer.newLine();
                writer.write("Extra Cheese: " + sandwiches.get(i).isExtraCheese());
                writer.newLine();
                writer.write("Sauces: " + sandwiches.get(i).getSauces());
                writer.newLine();
                writer.write("Chip: " + (chip == null ? "none" : chip.toString()));
                writer.newLine();
                writer.write("Drink: " + (drink == null ? "none" : drink.toString()));
                writer.newLine();
                writer.write("=======================================================");
                writer.newLine();
            }

            writer.write("Total Price: $" + price);
            writer.newLine();
            writer.write("=======================================================");
            writer.newLine();
            System.out.println("Thank You Come Again!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void loadReceipt() {
        File directory = new File(RECEIPT_DIRECTORY);

        if (directory.exists() && directory.isDirectory()) {
            File[] receiptFiles = directory.listFiles((dir, name) -> name.endsWith(RECEIPT_FILE_EXTENSION));

            if (receiptFiles != null && receiptFiles.length > 0) {
                System.out.println("List of Receipts:");
                for (File file : receiptFiles) {
                    System.out.println("Receipt File: " + file.getName());
                    System.out.println("Contents:");

                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                        System.out.println("=======================================================");
                    } catch (IOException e) {
                        System.out.println("Error reading receipt file: " + e.getMessage());
                    }
                }
            } else {
                System.out.println("No receipt files found in the directory.");
            }
        } else {
            System.out.println("Receipt directory does not exist.");
        }
    }
}