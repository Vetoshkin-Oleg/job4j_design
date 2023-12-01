package ru.job4j.ood.lsp.parking.transport;

public abstract class Transport {
    private final String name;
    private final double width;

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

    public String getType() {
        String result = this.getClass().getName();
        result = result.substring(result.lastIndexOf(".") + 1);
        return result;
    }
}