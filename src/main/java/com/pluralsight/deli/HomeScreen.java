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
                    OrderScreen orderScreen = new OrderScreen();
                    orderScreen.show();
                    break;
                case 2:
                    System.out.println("Have a good day! Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error. Please enter a valid option.");
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
        for (int i = 0; i < 50; i++) {
            System.out.print(character);
        }
        System.out.println();//Move to the next line after printing out the characters
    }
}

