package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException(String.format("This key: '%s' is missing", key));
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String line : args) {
            line = line.trim();
            checkLine(line);
            line = line.substring(1);
            String[] temp = line.split("=", 2);
            values.put(temp[0], temp[1]);
        }
    }

    private void checkLine(String line) {
        if (!line.contains("=")) {
            throw new IllegalArgumentException(
                    String.format("Error: This argument '%s' does not contain an equal sign", line));
        }
        if (!line.startsWith("-")) {
            throw new IllegalArgumentException(
                    String.format("Error: This argument '%s' does not start with a '-' character", line));
        }
        if (line.length() <= 2) {
            throw new IllegalArgumentException("No key and value!");
        }
        if (line.startsWith("-=")) {
            throw new IllegalArgumentException(
                    String.format("Error: This argument '%s' does not contain a key", line));
        }
        if (line.endsWith("=") && (line.indexOf("=") == line.lastIndexOf("="))) {
            throw new IllegalArgumentException(
                    String.format("Error: This argument '%s' does not contain a value", line));
        }
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}