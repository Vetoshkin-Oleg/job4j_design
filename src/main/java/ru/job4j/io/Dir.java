package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class Dir {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage  ROOT_FOLDER.");
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.printf("Total size : %s%n", file.getTotalSpace());
        for (File subfile : Objects.requireNonNull(file.listFiles())) {
            String separator = System.lineSeparator();
            if (subfile.isDirectory()) {
                Path path = Paths.get(subfile.getPath());
                long size = 0;
                try (Stream<Path> walk = Files.walk(path)) {
                    size = walk
                            .filter(Files::isRegularFile)
                            .mapToLong(p -> {
                                try {
                                    return Files.size(p);
                                } catch (IOException e) {
                                    System.out.printf("Невозможно получить размер файла %s%n%s", p, e);
                                    return 0L;
                                }
                            })
                            .sum();
                } catch (IOException e) {
                    System.out.printf("Ошибка при подсчёте размера директории %s", e);
                }
                System.out.printf("Name directory: %s, size: %s bytes%s", subfile.getName(), size, separator);
            }
            System.out.printf("Name file: %s, size: %s bytes%s", subfile.getName(), subfile.length(), separator);
        }
    }
}