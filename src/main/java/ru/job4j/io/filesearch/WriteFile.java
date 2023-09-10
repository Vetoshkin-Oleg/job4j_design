package ru.job4j.io.filesearch;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;

public class WriteFile {
    public static void print(List<Path> findFiles, ArgsName argsName) {
        String out = argsName.get("o");
        try (PrintWriter pw = new PrintWriter(new FileWriter(out, false))) {
            for (Path p : findFiles) {
                pw.print(p);
                pw.print(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}