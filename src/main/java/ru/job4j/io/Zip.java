package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    private static String sourceFolder;
    private static String excludeFiles;
    private static String outputArchive;

    public void packFiles(List<Path> sources, File target) {

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

    public static void main(String[] args) {
        checkArguments(args);
    }

    private static void checkArguments(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        sourceFolder = argsName.get("d");
        excludeFiles = argsName.get("e");
        outputArchive = argsName.get("o");

        if (args.length != 3) {
            throw new IllegalArgumentException("Количество аргументов командной строки должно быть равно 3");
        }
        if (!(Files.exists(Path.of(sourceFolder)) && Files.isDirectory(Path.of(sourceFolder)))) {
            throw new IllegalArgumentException("Первый аргумент командной строки не указывает на существующую папку,"
                    + " подлежащую архивации");
        }
        if (!((excludeFiles.length() >= 2) && (excludeFiles.charAt(0) == '.')
                && Character.isLetter(excludeFiles.charAt(1)))) {
            throw new IllegalArgumentException("Второй аргумент командной строки не является расширением файлов,"
                    + " которые следует исключить из архивации");
        }
        if (!(outputArchive.endsWith(".zip"))) {
            throw new IllegalArgumentException("Третий аргумент командной строки не является корректным именем"
                    + " для результирующего архива");
        }
    }
}