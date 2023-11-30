package com.pluralsight.deli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Side {
    private String auJus;
    private static final List<String> condiments = new ArrayList<>(Arrays.asList("mayonnaise", "mustard", "ketchup",
            "ranch", "thousand islands", "vinaigrette"));

    public Side(String auJus) {
        this.auJus = auJus;
    }

    public String getAuJus() {
        return auJus;
    }

    public static String getCondiments(){
        return String.valueOf(new ArrayList<String>(condiments));
    }
}