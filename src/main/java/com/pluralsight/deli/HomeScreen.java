package com.pluralsight.deli;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class HomeScreen {
    //Methods to display the main functionality of the home screen
    public void show(){
        displayWelcomeMessage(); // display the welcome message

        Scanner scanner = new Scanner(System.in);

        while (true){
            displayOptions(); // Display the available options
            int choice = getUserChoice(scanner); //get user choice

            //perform actions based on the user choice
            switch (choice){
                case 1:
                    System.out.println("Redirecting to Order Screen...");
                    // add code to transition to the order screen
                    break;
                case 2:
                    System.out.println("Exiting the Program. Have a good day! Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    // Method to display the welcome message
    public void displayWelcomeMessage(){
        System.out.println("Welcome to Deli-Kart Sandwiches");
        barrier('=');
    }

    //method to show the available options
    public void displayOptions(){
        System.out.println("1. Place an Order");
        System.out.println("2. Exit");
        barrier('=');
        System.out.println("Enter your choice: ");
    }

    //method to get and validate the user's choice
    private int getUserChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number");
            scanner.nextLine();
            barrier('=');
        }
        return scanner.nextInt();
    }

    public static void barrier(char character){
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
