package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Map<FileProperty, List<Path>> map = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(attrs.size(), file.getFileName().toString());
        if (!map.containsKey(fileProperty)) {
            List<Path> paths = new ArrayList<>();
            paths.add(file.toAbsolutePath().normalize());
            map.put(fileProperty, paths);
        } else {
            map.get(fileProperty).add(file.toAbsolutePath().normalize());
        }
        return super.visitFile(file, attrs);
    }

    public void print() {
        for (Map.Entry<FileProperty, List<Path>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println(entry.getKey().getName() + " - " + entry.getKey().getSize() + " bytes");
                for (Path p : entry.getValue()) {
                    System.out.println(p.toAbsolutePath().normalize());
                }
            }
        }
    }
}