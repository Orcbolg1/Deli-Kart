package com.pluralsight.deli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Side {

    private static final List<String> condiments = new ArrayList<>(Arrays.asList("mayonnaise", "mustard", "ketchup",
            "ranch", "thousand islands", "vinaigrette", "au jus"));


    public static String getCondiments(){
        return String.valueOf(new ArrayList<String>(condiments));
    }
}