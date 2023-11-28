package com.pluralsight.deli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Side {
    private String auJus;
    private static final List<String> condiments = new ArrayList<>(Arrays.asList("Mayonnaise", "Mustard", "Ketchup",
            "Ranch", "Thousand Islands", "Vinaigrette"));

    public Side(String auJus) {
        this.auJus = auJus;
    }

    public String getAuJus() {
        return auJus;
    }

    public String getCondiments(){
        return String.valueOf(new ArrayList<String>(condiments));
    }
}