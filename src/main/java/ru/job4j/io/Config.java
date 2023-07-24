package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path)))  {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("#") || line.isBlank()) {
                    continue;
                }
                checkLine(line);
                String[] temp = line.split("=", 2);
                values.put(temp[0], temp[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkLine(String line) {
        if (!line.contains("=")) {
            throw new IllegalArgumentException("No equal sign!");
        }
        if (line.length() == 1) {
            throw new IllegalArgumentException("No key and value!");
        }
        if (line.startsWith("=")) {
            throw new IllegalArgumentException("No key!");
        }
        if (line.endsWith("=") && line.indexOf("=") == line.lastIndexOf("=")) {
            throw new IllegalArgumentException("No value!");
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public int getSize() {
        return values.size();
    }

    public static void main(String[] args) {
        System.out.println(new Config("data/app.properties"));
    }

}