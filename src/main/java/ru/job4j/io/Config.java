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
                if (line.trim().startsWith("#")) {
                    continue;
                } else if (line.trim().length() == 0) {
                    continue;
                } else if (checkLine(line)) {
                    String[] temp = splitLine(line);
                    values.put(temp[0], temp[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkLine(String line) {
        if (!line.contains("=")) {
            throw new IllegalArgumentException("No equal sign!");
        } else if (line.trim().startsWith("=")
                && (line.length() != 1)) {
            throw new IllegalArgumentException("No key!");
        } else if (line.trim().endsWith("=")
                && (line.trim().indexOf("=") == line.trim().lastIndexOf("="))
                && line.trim().length() != 1) {
            throw new IllegalArgumentException("No value!");
        } else if (line.trim().length() == 1) {
            throw new IllegalArgumentException("No key and value!");
        }
        return true;
    }

    public String[] splitLine(String line) {
        String[] temp = new String[2];
        if (line.trim().indexOf("=") == line.trim().lastIndexOf("=")) {
            temp = line.split("=");
        } else {
            temp[0] = line.substring(0, line.indexOf("="));
            temp[1] = line.substring(line.indexOf("=") + 1);
        }
        return temp;
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