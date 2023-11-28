package com.pluralsight.deli;

import java.util.ArrayList;
import java.util.List;

public class Side {
    private String auJus;
    private static final List<String> condiments = new ArrayList<>();
    static {
        condiments.add("Mayonnaise");
        condiments.add("Mustard");
        condiments.add("Ketchup");
        condiments.add("Ranch");
        condiments.add("Thousand Islands");
        condiments.add("Vinaigrette");
    }

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