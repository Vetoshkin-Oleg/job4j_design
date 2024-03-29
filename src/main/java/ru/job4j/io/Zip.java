package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    private static Path sourceFolder;
    private static String excludeFiles;
    private static File outputArchive;

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path p : sources) {
                zip.putNextEntry(new ZipEntry(p.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(p.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void populateFilesList() throws IOException {
        List<Path> paths = Search.search(sourceFolder, p -> !p.toFile().getName().endsWith(excludeFiles));
        packFiles(paths, outputArchive);
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public static void main(String[] args) {
        Zip zip = new Zip();
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
    }*/

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            throw new IllegalArgumentException("Количество аргументов командной строки должно быть равно 3");
        }
        checkArguments(args);
        Zip zip = new Zip();
        zip.populateFilesList();
    }

    private static void checkArguments(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        sourceFolder = Path.of(argsName.get("d"));
        excludeFiles = argsName.get("e");
        outputArchive = new File(argsName.get("o"));

        if (!(Files.exists(sourceFolder)
                && Files.isDirectory(sourceFolder))) {
            throw new IllegalArgumentException("Первый аргумент командной строки не указывает на существующую папку, подлежащую архивации");
        }
        if (!((excludeFiles.length() >= 2) && (excludeFiles.charAt(0) == '.')
                && Character.isLetter(excludeFiles.charAt(1)))) {
            throw new IllegalArgumentException("Второй аргумент командной строки не является расширением файлов, которые следует исключить из архивации");
        }
        if (!(outputArchive.toString().endsWith(".zip"))) {
            throw new IllegalArgumentException("Третий аргумент командной строки не является корректным именем для результирующего архива");
        }
    }
}