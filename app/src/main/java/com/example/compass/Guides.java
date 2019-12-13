package com.example.compass;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Guides {
    private static ArrayList<Guide> guides = new ArrayList<>();

    public static void addGuide(Guide guide){
        guides.add(guide);
    }

    public static void removeGuide(Guide guide){
        guides.remove(guide);
    }

    public static ArrayList<Guide> getGuides() {
        return guides;
    }
}