package ru.job4j.io.filesearch;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

public class VisitFiles implements FileVisitor<Path> {
    private final Predicate<Path> condition;
    private static final List<Path> inaccessibleDirectories = new ArrayList<>();
    private static final List<Path> foundFiles = new ArrayList<>();

    public VisitFiles(Predicate<Path> condition) {
        this.condition = condition;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (condition.test(file)) {
            foundFiles.add(file.toAbsolutePath().normalize());
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        inaccessibleDirectories.add(file.toAbsolutePath().normalize());
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        return CONTINUE;
    }

    public List<Path> getInaccessibleDirectories() {
        return inaccessibleDirectories;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}