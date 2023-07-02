package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("data/dataresult.txt")) {
            StringBuilder result = new StringBuilder();
            result.append("1 * 2 = 2");
            result.append(System.lineSeparator());
            result.append("1 * 3 = 3");
            result.append(System.lineSeparator());
            result.append("1 * 4 = 4");
            result.append(System.lineSeparator());
            result.append("1 * 5 = 5");
            result.append(System.lineSeparator());
            result.append("1 * 6 = 6");
            result.append(System.lineSeparator());
            result.append("1 * 7 = 7");
            result.append(System.lineSeparator());
            result.append("1 * 8 = 8");
            result.append(System.lineSeparator());
            result.append("1 * 9 = 9");
            result.append(System.lineSeparator());

            out.write(result.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}