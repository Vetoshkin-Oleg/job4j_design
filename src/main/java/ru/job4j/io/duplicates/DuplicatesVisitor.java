package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final List<FileProperty> list = new ArrayList<>();
    private final Set<FileProperty> set = new HashSet<>();
    private final Set<String> result = new HashSet<>();
    private final Map<Path, FileProperty> map = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(attrs.size(), file.getFileName().toString());
        list.add(fileProperty);
        map.put(file.toAbsolutePath().normalize(), fileProperty);

        for (FileProperty fileProperty1 : list) {
            if (Collections.frequency(list, fileProperty1) > 1) {
                set.add(fileProperty1);
            }
        }

        for (Map.Entry<Path, FileProperty> entry : map.entrySet()) {
            for (FileProperty f : set) {
                if (f.equals(entry.getValue())) {
                    System.out.println((entry.getKey().toString()));
                    result.add(entry.getKey().toString());
                }
            }
        }

        return super.visitFile(file, attrs);
    }

    public Set<String> getResult() {
        return result;
    }
}