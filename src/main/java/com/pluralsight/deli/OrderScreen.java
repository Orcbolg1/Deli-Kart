package com.pluralsight.deli;

import java.util.Scanner;
public class OrderScreen {
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

    public static void barrier ( char character){
        for (int i = 0; i < 30; i++) {
            System.out.print(character);
        }
        System.out.println();//Move to the next line after printing out the characters
    }

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
}
