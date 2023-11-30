package com.pluralsight.deli;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderScreen {
    private boolean hasChips;
    private boolean hasDrink;
    private Chip selectedChip;
    private Drink selectedDrink;

    public OrderScreen() {
        this.hasChips = false;
        this.hasDrink = false;
    }
    public boolean hasChips() {
        return hasChips;
    }

    public void setHasChips(boolean hasChips) {
        this.hasChips = hasChips;
    }

    public boolean hasDrink() {
        return hasDrink;
    }

    public void setHasDrink(boolean hasDrink) {
        this.hasDrink = hasDrink;
    }

    Scanner scanner = new Scanner(System.in);

    public void show() {
        displayOrderOptions();

        while (true) {
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    createSandwich();
                    break;
                case 2:
                    List<String> previousOrders = FileManager.loadReceipt();
                    for (String order : previousOrders) {
                        System.out.println(order);
                    }

                    // Prompt user to return to order screen or keep viewing
                    System.out.println("Do you want to go back to the order screen? (yes/no): ");
                    String goBackChoice = scanner.next().toLowerCase();
                    if (goBackChoice.equals("No")) {
                        continue; //Continue to the next order.
                    } else {
                        System.out.println("Returning to Home Screen...");
                        return; // Return to the order screen.
                    }
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


        // Ask if the user wants the sandwich toasted
        System.out.println("Do you want your bread toasted? (yes/no): ");
        boolean toasted = scanner.next().equalsIgnoreCase("yes");

        // Ask if the user wants to add chips
        System.out.println("Do you want to add chips to your order? (yes/no): ");
        String addChipsChoice = scanner.next().toLowerCase();
        if (addChipsChoice.equals("yes")) {
            addChipsToOrder();
            // Update the total price after adding chips
//            totalPrice += Chip.getPrice();
        }

        // Ask if the user wants to add drinks
        System.out.println("Do you want to add drinks to your order? (yes/no): ");
        String addDrinksChoice = scanner.next().toLowerCase();
        if (addDrinksChoice.equals("yes")) {
            addDrinksToOrder();
            // Update the total price after adding drinks
//            totalPrice += Drink.getPrice();
        }

        // Print out the order details
        System.out.println("Order Details:");
        System.out.println("Size: " + size + " inches");
        System.out.println("Bread: " + bread);
        System.out.println("Toasted: " + toasted);
        System.out.println("Regular Toppings: " + regularTopping);
        System.out.println("Meat: " + meat);
        System.out.println("Cheese: " + cheese);
        System.out.println("Extra Meat: " + extraMeat);
        System.out.println("Extra Cheese: " + extraCheese);
        System.out.println("Sauces: " + sides);

        // Print the selected chips and drinks
        printSelectedChips();
        printSelectedDrink();

        double totalPrice = calculateTotalPrice(sandwich, hasChips, hasDrink, meat, cheese, extraMeat, extraCheese);
        System.out.println("Total Price: $" + totalPrice);

        FileManager.writeOrderToReceipt(sandwich, totalPrice);

        return sandwich;
    }

    public double calculateTotalPrice(Sandwich sandwich, boolean hasChips, boolean hasDrink, String meat, String cheese, boolean extraMeat, boolean extraCheese) {
        double totalPrice = 0.0;

//
        // Calculate the total price for premium toppings
        double toppingPrice = getToppingPrice(sandwich, meat, cheese, extraMeat, extraCheese);

        //The ? symbol is part of the conditional (ternary) operator in Java. The expression condition ? valueIfTrue : valueIfFalse is a shorthand way of writing an if-else statement.
        // so if hasDrink ? and hasChips ? means that if its true it will get the price if else it returns 0.
        double drinkPrice = drinkPrice();
        double chipPrice = chipPrice();

        // Calculate the total price
        totalPrice += toppingPrice + drinkPrice + chipPrice + sandwich.getPrice();

        return totalPrice;
    }

    public double drinkPrice(){
        double drinkPrice = 0.0;
        return drinkPrice = drinkPrice + (hasDrink ? selectedDrink.getPrice() : 0.0);
    }

    public double chipPrice(){
        double chipPrice = 0;
        return chipPrice += hasChips ? selectedChip.getPrice() : 0.0;
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

        // Display the available chip flavors
        System.out.println("Available chips to choose: ");
        for (String flavor : Chip.getAvailableFlavors()) {
            System.out.println(flavor);
        }

        // Ask the user to select a chip flavor
        System.out.println("Enter the chip flavor: ");
        String selectedFlavor = scanner.next().trim().toLowerCase();

        if (Chip.getAvailableFlavors().contains(selectedFlavor)) {
            // Create an instance of the chip class with the selected flavor
            selectedChip = new Chip(selectedFlavor);
            System.out.println("Chips added to the order: " + selectedChip);
            setHasChips(true);
        } else {
            System.out.println("Invalid Chip Flavor. Chips not added to the order.");
        }
        barrier('=');
    }

    //Method to add drinks to the order
    public void addDrinksToOrder() {

        // Display the available drink flavors
        System.out.println("Available drinks to choose: ");
        for (String flavor : Drink.getAvailableFlavors()) {
            System.out.println(flavor);
        }

        // Ask the user to select a drink flavor
        System.out.println("Enter the Drink flavor: ");
        String selectedFlavor = scanner.next().trim().toLowerCase();

        if (Drink.getAvailableFlavors().contains(selectedFlavor)) {
            // Ask the user to select a drink size
            System.out.println("Available Drink Sizes: S (Small), M (Medium), L (Large)");
            System.out.println("Enter your drink size: ");
            char selectedSize = scanner.next().toUpperCase().charAt(0);

            // Check if selected size is valid
            if (selectedSize == 'S' || selectedSize == 'M' || selectedSize == 'L') {
                // Create an instance of the Drink class with the selected flavor and size
                selectedDrink = new Drink(selectedSize, selectedFlavor);
                System.out.println("Drink added to the order: " + selectedDrink);
                setHasDrink(true);
            } else {
                System.out.println("Invalid Drink Size. Drink not added to the order.");
            }
        } else {
            System.out.println("Invalid Drink Flavor. Drink not added to the order.");
        }
        barrier('=');
    }

    public String getMeatTopping() {
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

        System.out.print("Do you want extra meat? (yes/no): ");
        String choice = scanner.nextLine().toLowerCase();

        barrier('=');
        return choice.equals("yes");
    }

    public boolean isExtraCheese() {

        System.out.print("Do you want extra cheese? (yes/no): ");
        String choice = scanner.nextLine().toLowerCase();

        barrier('=');
        return choice.equals("yes");
    }

    public List<String> getSauceChoices() {
        List<String> selectedSauces = new ArrayList<>();

        System.out.println("Choose sauces for your sandwich (enter one at a time, type 'done' to finish):");

        // Display available sauces
        System.out.println("Available sauces: " + String.join(", ", Side.getCondiments()));

        // Continue adding sauces until the user enters 'done'
        while (true) {
            System.out.print("Enter a sauce (or 'done' to finish): \n");
            String sauce = scanner.nextLine().toLowerCase();

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

    public void printSelectedChips() {
        if (hasChips) {
            System.out.println("Selected Chips: " + selectedChip);
        } else {
            System.out.println("No chips selected.");
        }
    }

    public void printSelectedDrink() {
        if (hasDrink) {
            System.out.println("Selected Drink: " + selectedDrink);
        } else {
            System.out.println("No drink selected.");
        }
    }

    public double getToppingPrice(Sandwich sandwich, String meat, String cheese, boolean extraMeat, boolean extraCheese) {
        // Add 1 dollar to the base price for premium toppings
        double toppingPrice = 0;
        if (!meat.isEmpty()) {
            if (sandwich.getSize() == 4) {
                toppingPrice += 1;
            }
            if (sandwich.getSize() == 8) {
                toppingPrice += 2;
            }
            if (sandwich.getSize() == 12) {
                toppingPrice += 3;
            }
        }

        if (!cheese.isEmpty()) {
            if (sandwich.getSize() == 4) {
                toppingPrice += .75;
            }
            if (sandwich.getSize() == 8) {
                toppingPrice += 1.50;
            }
            if (sandwich.getSize() == 12) {
                toppingPrice += 2.25;
            }
        }

        double extraPrice = 0;
        if (extraMeat) {
            if (sandwich.getSize() == 4) {
                extraPrice += .50;
            }
            if (sandwich.getSize() == 8) {
                extraPrice += 1.00;
            }
            if (sandwich.getSize() == 12) {
                extraPrice += 1.50;
            }
        }

        if (extraCheese) {
            if (sandwich.getSize() == 4) {
                extraPrice += .30;
            }
            if (sandwich.getSize() == 8) {
                extraPrice += .60;
            }
            if (sandwich.getSize() == 12) {
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