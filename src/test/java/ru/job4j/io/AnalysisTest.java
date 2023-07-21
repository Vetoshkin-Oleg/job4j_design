package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class AnalysisTest {

    @Test
    void whenThreeIntervals(@TempDir Path tempDir) {
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter writer = new PrintWriter(source)) {
            writer.println("500 10:57:01" + System.lineSeparator()
                    + "400 10:58:01" + System.lineSeparator()
                    + "300 10:59:01" + System.lineSeparator()
                    + "500 11:01:02" + System.lineSeparator()
                    + "200 11:02:02" + System.lineSeparator()
                    + "300 11:03:02" + System.lineSeparator()
                    + "500 11:57:01" + System.lineSeparator()
                    + "400 11:58:01" + System.lineSeparator()
                    + "300 12:03:02");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        File target  = tempDir.resolve("target.txt").toFile();
        Analysis analysis = new Analysis();
        analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        String expect = "10:57:01;10:59:01;" + System.lineSeparator() + "11:01:02;11:02:02;"
                + System.lineSeparator() + "11:57:01;12:03:02;";
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            String line;
            while ((line = in.readLine()) != null) {
                rsl.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String result = rsl.substring(0,
                rsl.length() - System.lineSeparator().length());
        assertEquals(expect, result);
    }
}