package ru.job4j.serialization.json;

public class Engine {
    private final String name;

    public Engine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Engine{"
                + "name='" + name + '\''
                + '}';
    }
}