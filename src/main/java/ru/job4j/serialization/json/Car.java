package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Car {
    public static void main(String[] args) {
        final Porsche porsche = new Porsche(true, 2497, "Gasoline",
                new Engine("MDJ.UA, MDJ.UB, MDP.HB"),
                new String[] {"Horizontally opposed, 4-cylinder", "Turbine"});

        final Gson gson = new GsonBuilder().create();

        String json = gson.toJson(porsche);
        System.out.println(json);

        final Porsche porscheMod = gson.fromJson(json, Porsche.class);
        System.out.println(porscheMod);
    }
}
