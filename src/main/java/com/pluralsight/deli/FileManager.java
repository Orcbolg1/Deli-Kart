package com.pluralsight.deli;

import java.io.*;


public class FileManager {
    public static void addOrder(Sandwich sandwich, RegularTopping regularTopping, PremiumTopping premiumTopping,
                                Drink drink, Chip chip){
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("receipt.txt", true));
            String customerOrder = String.format("%s|%s|%s|%s", sandwich, regularTopping, premiumTopping, drink, chip);
            bufferedWriter.write(customerOrder);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void loadReceipt(){
        String line;
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("receipt.txt"));
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
