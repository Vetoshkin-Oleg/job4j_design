package ru.job4j.io;

import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.util.List;
import java.util.function.Predicate;

public class SearchFiles extends SimpleFileVisitor<Path> {
    public SearchFiles(Predicate<Path> condition) {
    }

    public List<Path> getPaths() {
        return null;
    }
}
