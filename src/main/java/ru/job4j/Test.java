package ru.job4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String input = args[0];

        String filePathIn = "C:\\projects\\job4j_design\\src\\main\\resources\\3000.txt";

        List<String> words = readFile(filePathIn);

        int count = 0;
        for (String s : words) {
            if (input.equals(s)) {
                count++;
            }
        }
        System.out.println("Количество вхождений слова в текстовом файле = " + count);
    }

    public static List<String> readFile(String pathFileIn) {
        List<String> result = new ArrayList<>();
        final Pattern KILL_CC_PATTERN = Pattern.compile("\uFEFF");
        Matcher m;
        try (FileReader fileReader = new FileReader(pathFileIn);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                m = KILL_CC_PATTERN.matcher(line);
                line = m.replaceAll("");
                String[] temp = line.split(" ");
                result.addAll(Arrays.asList(temp));
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}