package ru.job4j.ood.lsp.parking.transport;

public abstract class Transport {
    private final String name;
    private final double spots;

    public Transport(String name, double spots) {
        this.name = name;
        this.spots = spots;
    }

    public String getName() {
        return name;
    }

    public double getSpots() {
        return spots;
    }
}