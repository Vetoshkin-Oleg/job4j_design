package ru.job4j.io;

import java.nio.file.Files;
import java.nio.file.Path;

public class CSVReader {
    private static Path sourceFile;
    private static String delimiter;
    private static String out;
    private static String filter;

    public static void handle(ArgsName argsName) {
        System.out.println(sourceFile);
        System.out.println(delimiter);
        System.out.println(out);
        System.out.println(filter);
    }

    public static void main(String[] args) throws Exception {
        String[] arg = new String[4];
        arg[0] = "-path=file.csv";
        arg[1] = "-delimiter=;";
        arg[2] = "-out=stdout";
        arg[3] = "-filter=name,age";
        if (arg.length != 4) {
            throw new IllegalArgumentException("Количество аргументов командной строки должно быть равно 4");
        }
        checkArguments(arg);
    }

    private static void checkArguments(String[] args) throws Exception {
        ArgsName argsName = ArgsName.of(args);
        sourceFile = Path.of(argsName.get("path"));
        delimiter = argsName.get("delimiter");
        out = argsName.get("out");
        filter = argsName.get("filter");

        if (!(Files.isRegularFile(sourceFile)
                && sourceFile.toString().endsWith(".csv"))) {
            throw new IllegalArgumentException("Первый аргумент командной строки не указывает на существующий файл с расширением \"csv\"");
        }
        if (!"stdout".equals(out)) {
            String tempExtension = out.substring(out.lastIndexOf('.'));
            if (!((tempExtension.length() >= 2) && (tempExtension.charAt(0) == '.')
                    && Character.isLetter(tempExtension.charAt(1)))) {
                throw new IllegalArgumentException("Третий аргумент командной строки не является возможным адресом (именем) файла для сохранения результатов,"
                        + " а также не является параметром \"stdout\"");
            }
        }
        handle(argsName);
    }
}