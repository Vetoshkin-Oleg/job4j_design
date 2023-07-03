package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class LogFilter {
    public List<String> filter(String file) {
        List<String> result = null;
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            result = in.lines()
                    .filter(s1 -> s1
                            .startsWith("404", s1.lastIndexOf(' ') - 3))
                    .toList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("data/log.txt");
        log.forEach(System.out::println);
    }
}