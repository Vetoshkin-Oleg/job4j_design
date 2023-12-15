package ru.job4j.ood.lsp.parking.transport;

import java.util.HashMap;
import java.util.Map;

public abstract class Transport {
    private final String name;
    private final double width;

    private final Map<Integer, Double> spotsRecords = new HashMap<>();
    private final Map<String, Map<Integer, Double>> carsRecords = new HashMap<>();

    public Transport(String name, double width) {
        this.name = name;
        this.width = width;
    }

    public String getName() {
        return name;
    }

    public double getWidth() {
        return width;
    }

    public Map<Integer, Double> getSpotsRecords() {
        return spotsRecords;
    }

    public void setSpotsRecords(int spotNumber, double spotValue) {
        spotsRecords.put(spotNumber, spotValue);
    }

    public Map<String, Map<Integer, Double>> getCarsRecords() {
        return carsRecords;
    }

    public void setCarsRecords(String name) {
        carsRecords.put(name, this.getSpotsRecords());
    }
}