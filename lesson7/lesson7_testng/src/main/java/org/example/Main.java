package org.example;

import org.example.calculateAreaTriangle.AreaTriangle;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.####");
        System.out.println(df.format(AreaTriangle.calculateAreaTriangle(0.03, 0.04, 0.05)));
    }
}