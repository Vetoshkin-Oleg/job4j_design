package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        String result = null;
        StringBuilder stringBuilder = new StringBuilder();
        boolean isStart = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(source)))  {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!isStart && checkLine(line)) {
                    stringBuilder.append(line.substring(4)).append(";");
                    isStart = true;
                } else if (isStart && !checkLine(line)) {
                    stringBuilder.append(line.substring(4)).append(";");
                    stringBuilder.append(System.lineSeparator());
                    isStart = false;
                }
            }
            result = stringBuilder.substring(0,
                    stringBuilder.length() - System.lineSeparator().length());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter writer = new PrintWriter(target)) {
            writer.print(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkLine(String line) {
        return "400".equals(line.substring(0, 3)) || "500".equals(line.substring(0, 3));
    }

    public static void main(String[] args) {
        Analysis analysis1 = new Analysis();
        analysis1.unavailable("data/server_1.log", "data/target_1.csv");
        Analysis analysis2 = new Analysis();
        analysis2.unavailable("data/server_2.log", "data/target_2.csv");
        Analysis analysis3 = new Analysis();
        analysis3.unavailable("data/server_3.log", "data/target_3.csv");
    }
}