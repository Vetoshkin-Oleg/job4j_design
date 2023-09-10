package ru.job4j.io.filesearch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            throw new IllegalArgumentException("Количество аргументов командной строки должно быть равно 4");
        }
        ArgsName argsName = ArgsName.of(args);
        checkArguments(argsName);
        Predicate<Path> condition = pred(argsName);
        List<Path> findFiles = search(argsName, condition);
        WriteFile.print(findFiles, argsName);

        List<Path> accessDenied = new VisitFiles(condition).getInaccessibleDirectories();
        if (accessDenied.size() > 0) {
            System.out.println("Список папок, недоступных для чтения:");
            System.out.println("-------------------------------------");
            for (Path p : accessDenied) {
                System.out.println(p);
            }
            System.out.printf("Количество недоступных папок - %d%n", accessDenied.size());
        }
    }

    private static Predicate<Path> pred(ArgsName argsName) {
        Predicate<Path> condition = null;
        String name = argsName.get("n");
        String searchType = argsName.get("t");
        switch (searchType) {
            case ("name") :
                condition = p -> p.toFile().getName().equalsIgnoreCase(name);
                break;
            case ("mask") :
                System.out.println("mask");
                break;
            case ("regex") :
                System.out.println("regex");
                break;
        }
        return condition;
    }

    public static List<Path> search(ArgsName argsName, Predicate<Path> condition) throws IOException {
        Path root = Path.of(argsName.get("d"));
        VisitFiles searcher = new VisitFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getFoundFiles();
    }

    private static void checkArguments(ArgsName argsName) {
        String sourceDirectory = argsName.get("d");
        if (Character.isLetter(sourceDirectory.charAt(0))
                && (':' == (sourceDirectory.charAt(1)))
                && sourceDirectory.length() == 2) {
            throw new IllegalArgumentException("Для поиска по диску \"D\" требуется указать первый аргумент в виде \"D:\\\\\"."
                    + " Для поиска по другим дискам - аналогично");
        }
        if (!(new File(sourceDirectory).isDirectory())) {
            throw new IllegalArgumentException("Первый аргумент не указывает на существующую директорию");
        }

        String name = argsName.get("n");
        String searchType = argsName.get("t");
        int dotPosition = name.lastIndexOf(".");
        if (dotPosition == -1 && "name".equals(searchType)) {
            throw new IllegalArgumentException("Второй аргумент указан неправильно для поиска по имени файла: отсутствует знак \"точка\"");
        }
        String nameTemp = name.substring(0, dotPosition);
        String extensionTemp = name.substring(dotPosition + 1);
        if (nameTemp.length() == 0 && extensionTemp.length() == 0) {
            throw new IllegalArgumentException("Второй аргумент содержит знак \"точка\", но не содержит имя и расширение для поиска");
        }
        if (nameTemp.length() == 0 && (!"regex".equals(searchType))) {
            throw new IllegalArgumentException("Второй аргумент не содержит имя для поиска по имени или по маске файла");
        }
        if (extensionTemp.length() == 0 && (!"regex".equals(searchType))) {
            throw new IllegalArgumentException("Второй аргумент не содержит расширение для поиска по имени или по маске файла");
        }
        if (!("name".equals(searchType) || "mask".equals(searchType) || "regex".equals(searchType))) {
            throw new IllegalArgumentException("Третий аргумент должен иметь одно из трех значений: name, mask, regex");
        }

        String out = argsName.get("o");
        int outDotPosition = out.lastIndexOf('.');
        if (outDotPosition == -1) {
            throw new IllegalArgumentException("Четвертый аргумент командной строки содержит некорректное значение файла для вывода результата: "
                    + "отсутствует имя либо расширение");
        }
        String outName = out.substring(0, outDotPosition);
        String outExtension = out.substring(outDotPosition + 1);
        if (outName.length() == 0) {
            throw new IllegalArgumentException("Четвертый аргумент командной строки не содержит корректное имя файла для сохранения результатов");
        }
        if (!((outExtension.length() >= 1)
                && Character.isLetter(outExtension.charAt(0)))) {
            throw new IllegalArgumentException("Четвертый аргумент командной строки не содержит корректное расширение файла для сохранения результатов");
        }
    }
}