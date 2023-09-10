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

        /*VisitFiles pf = new VisitFiles(condition);
        Files.walkFileTree(rootDir, pf);

        private static Predicate<Path> pred(String extension) {
            return p -> p.toFile().getName().endsWith(extension);
        }

        List<Path> result = new VisitFiles(condition).getFoundFiles();
        for (Path p : result) {
            System.out.println(p);
        }
        System.out.println(result.size());*/

        /*System.out.println();
        List<Path> accessDenied = new VisitFiles(condition).getInaccessibleDirectories();
        System.out.println("Список папок, недоступных для чтения");
        for (Path p : accessDenied) {
            System.out.println(p);
        }
        System.out.println(accessDenied.size());*/
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
        if (dotPosition == -1 && (!"regex".equals(searchType))) {
            throw new IllegalArgumentException("Второй аргумент указан неправильно для поиска по имени или по маске файла");
        }
        String nameTemp = name.substring(0, dotPosition);
        String extensionTemp = name.substring(dotPosition + 1);
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