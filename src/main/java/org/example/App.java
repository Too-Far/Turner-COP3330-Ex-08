/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Ryan Turner
 */
package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class App
{
    public static void generateMessage(int people, int totalSlices, int remaining, int slicesDispersed, int pizzas)
    {
        if (slicesDispersed == 0) {
            System.out.println("There is not enough pizza to distribute evenly!");
        } else {
            System.out.println(
                    people + " people with " + pizzas + " pizzas (" + totalSlices + " total slices) \n Each person gets "
                            + slicesDispersed + " pieces of pizza. \n There are " + remaining + " leftover pieces."
            );
        }
    }

    public static void performPizzaCalcs(Map<String, Integer> info)
    {
        int people = info.get("people");
        int totalSlices = info.get("pizzas") * info.get("slices");
        int remaining = totalSlices % people;
        int slicesDispersed = totalSlices / people;

        generateMessage(people, totalSlices, remaining, slicesDispersed, info.get("pizzas"));
    }

    public static void gatherInfo()
    {
        Map<String, Integer> info = new HashMap<>();
        do {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("How many people? ");

                info.put("people", Integer.parseInt(reader.readLine()));

                System.out.println("How many pizzas do you have? ");
                info.put("pizzas", Integer.parseInt(reader.readLine()));

                System.out.println("How many slices per pizza? ");
                info.put("slices", Integer.parseInt(reader.readLine()));
                break;
            } catch (Exception e)
            {
                System.out.println("Please input a number.");
            }
            } while (true);
        performPizzaCalcs(info);
    }

    public static void main( String[] args ) {
        gatherInfo();
    }
}
