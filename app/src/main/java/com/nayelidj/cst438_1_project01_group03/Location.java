package com.nayelidj.cst438_1_project01_group03;


import java.util.ArrayList;
import java.util.List;

public class Location {
    private ArrayList<String> area = new ArrayList<String>();

    //name of the place, such as a city
    private String display_name;

    public ArrayList<String> getArea() {
        return area;
    }

    public String getDisplay_name() {
        return display_name;
    }
}
