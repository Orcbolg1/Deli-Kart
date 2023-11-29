package com.pluralsight.deli;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderScreen {
    public void show() {
        displayOrderOptions();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    createSandwich();
                    break;
                case 2:
                    // Logic for viewing order history or other options
                    break;
                case 3:
                    System.out.println("Returning to Home Screen...");
                    return; // This will exit the show() method and go back to the HomeScreen loop
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private void displayOrderOptions() {
        System.out.println("Order Screen:");
        System.out.println("1. Build and Place an Order");
        System.out.println("2. View Order History");
        System.out.println("3. Return to Home Screen");
        System.out.print("Enter your choice:\n ");
    }

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
        System.out.println("Size: " + size + " inches");
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
            scanner.nextInt(); // Consume the invalid input
            scanner.nextLine();
        }
        return scanner.nextInt();
    }

    //Method to get Sandwich size
    public int getBreadSize() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select Sandwich Size: ");
        System.out.println("1) 4\"");
        System.out.println("2) 8\"");
        System.out.println("3) 12\"");

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

        barrier('=');
        System.out.println("Select the type of bread:");
        System.out.println("1. White");
        System.out.println("2. Wheat");
        System.out.println("3. Rye");
        System.out.println("4. Wrap");
        System.out.print("Enter your choice:\n");

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
        RegularTopping regularTopping = new RegularTopping();
        List<String> selectedToppings = new ArrayList<>();

        barrier('=');
        System.out.println("Choose regular toppings (enter one at a time, type 'done' to finish):");

        // Display available regular toppings
        System.out.println("Available regular toppings: " + String.join(", ", regularTopping.getTopping()));

        // Continue adding toppings until the user enters 'done'
        while (true) {
            System.out.print("Enter a regular topping (or 'done' to finish):\n ");
            String topping = scanner.nextLine();

            if (topping.equalsIgnoreCase("done")) {
                break;
            }

            // Validate if the entered topping is valid
            if (!regularTopping.getTopping().contains(topping.toLowerCase())) {
                System.out.println("Invalid topping. Please choose from the available options.");
                continue;
            }

            selectedToppings.add(topping);
        }
        barrier('=');
        return selectedToppings;
    }


    //Method to add chips to the order
    public void addChipsToOrder() {

        //Display the available Chip flavour
        System.out.println("Available chips to choose: ");
        for (String flavor : Chip.getAvailableFlavors()) {
            System.out.println(flavor);

        }

        // Ask the user to select a chip flavour
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the chip flavour: ");
        String selectedFlavour = scanner.nextLine().trim().toLowerCase(); // Convert to lower case

        //check if the selected flavour is valid
        if (Chip.getAvailableFlavors().stream().anyMatch(flavor -> flavor.equalsIgnoreCase(selectedFlavour))) {

            //create an instance of the chip class with the selected flavor
            Chip chip = new Chip(selectedFlavour);
            System.out.println(chip + " added to your order");

        } else {
            System.out.println("Invalid Chip Flavor. Chips not added to the order.");
        }
        barrier('=');
    }

    //Method to add drinks to the order
    public void addDrinksToOrder() {
        //Display the available Drink flavour
        System.out.println("Available drinks to choose: ");
        for (String flavour : Drink.getAvailableFlavors()) {
            System.out.println(flavour);

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

            //Check to see if selected size is valid
            if (selectedSize == 'S' || selectedSize == 'M' || selectedSize == 'L') {
                //Create an instance of the Drink class with the selected flavor and size
                Drink drink = new Drink(selectedSize, selectedFlavour);
                System.out.println("Drink added to the order: " + drink);
                barrier('=');
            } else {
                System.out.println("Invalid Drink Size. Drink not added to the order.");
                barrier('=');
            }
        } else {
            System.out.println("Invalid Drink Flavour. Drink not added to the order.");
            barrier('=');
        }

    }

    public String getMeatTopping() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose one of the available meat toppings:");

        // Display available meat toppings
        System.out.println(String.join(", ", PremiumTopping.getMeatToppings()));

        // Prompt user to enter a meat topping
        System.out.print("Enter a meat topping:\n ");
        String meat = scanner.nextLine();
        String meatTopping = meat.toLowerCase();
        // Validate if the entered meat topping is valid
        if (!PremiumTopping.getMeatToppings().stream().anyMatch(t -> t.equalsIgnoreCase(meat))) {
            System.out.println("Invalid meat topping. Please choose from the available options.");
            return getMeatTopping(); // Recursively call the method to retry
        }
        barrier('=');
        return meat;
    }

    public String getCheeseTopping() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose one of the available cheese toppings:");

        // Display available cheese toppings
        System.out.println(String.join(", ", PremiumTopping.getCheeseToppings()));

        // Prompt user to enter a cheese topping
        System.out.print("Enter a cheese topping:\n");
        String cheese = scanner.nextLine();

        // Validate if the entered cheese topping is valid
        if (!PremiumTopping.getCheeseToppings().stream().anyMatch(t -> t.equalsIgnoreCase(cheese))) {
            System.out.println("Invalid cheese topping. Please choose from the available options.");
            return getCheeseTopping(); // Recursively call the method to retry
        }
        barrier('=');
        return cheese;
    }

    public boolean isExtraMeat() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want extra meat? (yes/no): ");
        String choice = scanner.nextLine().toLowerCase();

        barrier('=');
        return choice.equals("yes");
    }

    public boolean isExtraCheese() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want extra cheese? (yes/no): ");
        String choice = scanner.nextLine().toLowerCase();

        barrier('=');
        return choice.equals("yes");
    }

    public List<String> getSauceChoices() {
        Scanner scanner = new Scanner(System.in);
        List<String> selectedSauces = new ArrayList<>();

        System.out.println("Choose sauces for your sandwich (enter one at a time, type 'done' to finish):");

        // Display available sauces
        System.out.println("Available sauces: " + String.join(", ", Side.getCondiments()));

        // Continue adding sauces until the user enters 'done'
        while (true) {
            System.out.print("Enter a sauce (or 'done' to finish): \n");
            String sauce = scanner.nextLine();

            if (sauce.equalsIgnoreCase("done")) {
                break;
            }

            // Validate if the entered sauce is valid
            if (!Side.getCondiments().contains(sauce)) {
                System.out.println("Invalid sauce. Please choose from the available options.");
                continue;
            }

            selectedSauces.add(sauce);
        }
        barrier('=');
        return selectedSauces;
    }
    public double getToppingPrice(Sandwich sandwich, String meat, String cheese, boolean extraMeat, boolean extraCheese) {
        // Add 1 dollar to the base price for premium toppings
        double toppingPrice = 0;
        if(!meat.isEmpty()){
            if (sandwich.getSize() == 4){
                toppingPrice += 1;
            }
            if (sandwich.getSize() == 8){
                toppingPrice += 2;
            }
            if (sandwich.getSize() == 12){
                toppingPrice += 3;
            }
        }

        if(!cheese.isEmpty()){
            if (sandwich.getSize() == 4){
                toppingPrice += .75;
            }
            if (sandwich.getSize() == 8){
                toppingPrice += 1.50;
            }
            if (sandwich.getSize() == 12){
                toppingPrice += 2.25;
            }
        }

        double extraPrice = 0;
        if (extraMeat){
            if (sandwich.getSize() == 4){
                extraPrice += .50;
            }
            if (sandwich.getSize() == 8){
                extraPrice += 1.00;
            }
            if (sandwich.getSize() == 12){
                extraPrice += 1.50;
            }
        }

        if (extraCheese){
            if (sandwich.getSize() == 4){
                extraPrice += .30;
            }
            if (sandwich.getSize() == 8){
                extraPrice += .60;
            }
            if (sandwich.getSize() == 12){
                extraPrice += .90;
            }
        }
        return toppingPrice + extraPrice;
    }
    public static void barrier(char character) {
        for (int i = 0; i < 30; i++) {
            System.out.print(character);
        }
        System.out.println();//Move to the next line after printing out the characters
    }

}