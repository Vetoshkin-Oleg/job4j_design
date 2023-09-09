package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Количество аргументов командной строки должно быть равно 2");
        }
        if (!isValidFolder(args[0])) {
            throw new IllegalArgumentException("Первый аргумент командной строки не указывает на существующую папку");
        }
        if (!isValidExtension(args[1])) {
            throw new IllegalArgumentException("Второй аргумент командной строки не является расширением файла");
        }
        Path start = Paths.get(args[0]);
        Predicate<Path> condition = pred(args[1]);
        search(start, condition).forEach(System.out::println);
    }

    private static Predicate<Path> pred(String extension) {
        return p -> p.toFile().getName().endsWith(extension);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    private static boolean isValidFolder(String args) {
        Path path = Path.of(args);
        return Files.exists(path) && Files.isDirectory(path);
    }

    private static boolean isValidExtension(String args) {
        return (args.length() >= 2) && (args.charAt(0) == '.') && Character.isLetter(args.charAt(1));
    }
}