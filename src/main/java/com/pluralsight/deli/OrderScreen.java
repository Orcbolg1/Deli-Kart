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




    public int getUserChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextInt();
    }

    //Method to get Sandwich size
    public int getBreadSize(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select Sandwich Size: ");
        System.out.println("(4\")");
        System.out.println("(8\")");
        System.out.println("(12\")");

        barrier('=');

        int choice = getUserChoice(scanner);
        switch (choice) {
            case 1:
                return 4;
            case 2:
                return 8;
            case 3:
                return 12;
            default:
                System.out.println("Invalid choice. Defaulting to 4\".");
                return 4; // Default to 4" in case of an invalid choice
        }
    }

    public String getBread() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select the type of bread:");
        System.out.println("1. White");
        System.out.println("2. Wheat");
        System.out.println("3. Rye");
        System.out.println("4. Wrap");
        System.out.print("Enter your choice: ");

        int choice = getUserChoice(scanner);

        switch (choice) {
            case 1:
                return "White";
            case 2:
                return "Wheat";
            case 3:
                return "Rye";
            case 4:
                return "Wrap";
            default:
                System.out.println("Invalid choice. Defaulting to Wheat.");
                return "Wheat"; // Default to Wheat in case of an invalid choice
        }
    }

    public List<String> getRegularToppings() {
        Scanner scanner = new Scanner(System.in);
        List<String> selectedToppings = new ArrayList<>();

        System.out.println("Choose regular toppings (enter one at a time, type 'done' to finish):");

        // Display available regular toppings
        System.out.println("Available regular toppings: " + String.join(", ", RegularTopping.getTopping()));

        // Continue adding toppings until the user enters 'done'
        while (true) {
            System.out.print("Enter a regular topping (or 'done' to finish): ");
            String topping = scanner.nextLine();

            if (topping.equalsIgnoreCase("done")) {
                break;
            }

            // Validate if the entered topping is valid
            if (!RegularTopping.getTopping().contains(topping.toLowerCase())) {
                System.out.println("Invalid topping. Please choose from the available options.");
                continue;
            }

            selectedToppings.add(topping);
        }

        return selectedToppings;
    }


    //Method to add chips to the order
    public void addChipsToOrder() {
        System.out.println("Added Chips to your Order");
        barrier('=');

        //Display the available Chip flavour
        System.out.println("Available chips to choose: ");
        for (String flavor : Chip.getAvailableFlavors()) {
            System.out.println(flavor);
            barrier('=');
        }

        // Ask the user to select a chip flavour
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the chip flavour: ");
        String selectedFlavour = scanner.nextLine().trim().toLowerCase(); // Convert to lower case

        //check if the selected flavour is valid
        if (Chip.getAvailableFlavors().stream().anyMatch(flavor -> flavor.equalsIgnoreCase(selectedFlavour))) {

            //create an instance of the chip class with the selected flavor
            Chip chip = new Chip(selectedFlavour);
            System.out.println("Chips added to the order: " + chip);
        } else {
            System.out.println("Invalid Chip Flavor. Chips not added to the order.");
        }
    }

    //Method to add drinks to the order
    public void addDrinksToOrder () {
        System.out.println("Added Drinks to your Order");
        barrier('=');

        //Display the available Drink flavour
        System.out.println("Available drinks to choose: ");
        for (String flavour : Drink.getAvailableFlavors()) {
            System.out.println(flavour);
            barrier('=');
        }

        // Ask the user to select a chip flavour
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Drink flavour: ");
        String selectedFlavour = scanner.nextLine().trim().toLowerCase(); // Convert to lower case

        //check if the selected flavour is valid
        if (Drink.getAvailableFlavors().stream().anyMatch(flavor -> flavor.equalsIgnoreCase(selectedFlavour))) {
            // Ask the user to select a drink size
            System.out.println("Available Drink Sizes: S (Small), M (Medium), L (Large)");
            System.out.println("Enter your drink size: ");
            char selectedSize = scanner.next().toUpperCase().charAt(0);
            barrier('=');

            //Check to see if selected size is valid
            if (selectedSize == 'S' || selectedSize == 'M' || selectedSize == 'L') {
                //Create an instance of the Drink class with the selected flavor and size
                Drink drink = new Drink(selectedSize, selectedFlavour);
                System.out.println("Drink added to the order: " + drink);
            } else {
                System.out.println("Invalid Drink Size. Drink not added to the order.");
            }
        } else {
            System.out.println("Invalid Drink Flavour. Drink not added to the order.");
        }
    }

}