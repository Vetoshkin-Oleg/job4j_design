package ru.job4j.serialization.json;

import java.util.Arrays;

public class Porsche {
    private final boolean isCabriolet;
    private final int engineVolume;
    private final String fuel;
    private final Engine engine;
    private final String[] description;

    public Porsche(boolean isCabriolet, int engineVolume, String fuel,
                   Engine engine, String[] description) {
        this.isCabriolet = isCabriolet;
        this.engineVolume = engineVolume;
        this.fuel = fuel;
        this.engine = engine;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Porsche{"
                + "isCabriolet=" + isCabriolet
                + ", engineVolume=" + engineVolume
                + ", fuel='" + fuel + '\''
                + ", engine=" + engine
                + ", description=" + Arrays.toString(description)
                + '}';
    }
}