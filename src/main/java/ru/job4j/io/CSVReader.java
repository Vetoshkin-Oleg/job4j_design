package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CSVReader {
    private static Path sourceFile;
    private static String delimiter;
    private static String out;
    private static String filter;
    private static List<String> selectedColumns = new ArrayList<>();

    public static void handle(ArgsName argsName) throws IOException {
        filterColumn(sourceFile);
//        readFile(sourceFile);
    }

    private static void filterColumn(Path path) throws IOException {
        List<String> header;
        var scanner = new Scanner(path);
        String headLine = scanner.nextLine();
        headLine = headLine.substring(1, headLine.length() - 1);
        header = List.of(headLine.split(delimiter));
        selectedColumns.addAll(Arrays.asList(filter.split(",")));
        if (!new HashSet<>(header).containsAll(selectedColumns)) {
            throw new IllegalArgumentException("Четвертый аргумент командной строки введен некорректно: "
                    + "не все заголовки параметра filter входят в список заголовков всех столбцов файла");
        }
    }

    private static void print(List<String> list, String out) {
        if ("stdout".equals(out)) {
            for (String s : list) {
                System.out.println(s);
            }
        } else {
            try (PrintWriter pw = new PrintWriter(new FileWriter(out, false))) {
                for (String s : list) {
                    pw.println(s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readFile(Path path) throws IOException {
        var scanner = new Scanner(path).useDelimiter(delimiter);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    public static void main(String[] args) throws Exception {
        String[] arg = new String[4];
        arg[0] = "-path=file.csv";
        arg[1] = "-delimiter=;";
        arg[2] = "-out=stdout.csv";
        arg[3] = "-filter=name,age";
        if (arg.length != 4) {
            throw new IllegalArgumentException("Количество аргументов командной строки должно быть равно 4");
        }
        ArgsName argsName = ArgsName.of(arg);
        sourceFile = Path.of(argsName.get("path"));
        delimiter = argsName.get("delimiter");
        out = argsName.get("out");
        filter = argsName.get("filter");

        checkArguments();
        filterColumn(sourceFile);
        handle(argsName);
//        print(out);
    }

    private static void checkArguments() {
        if (!(Files.isRegularFile(sourceFile)
                && sourceFile.toString().endsWith(".csv"))) {
            throw new IllegalArgumentException("Первый аргумент командной строки не указывает на существующий файл с расширением \"csv\"");
        }
        if (!"stdout".equals(out)) {
            String tempExtension = out.substring(out.lastIndexOf('.'));
            if (!((tempExtension.length() >= 2) && (tempExtension.charAt(0) == '.')
                    && Character.isLetter(tempExtension.charAt(1)))) {
                throw new IllegalArgumentException("Третий аргумент командной строки не является возможным адресом (именем) файла для сохранения результатов,"
                        + " а также не имеет значение \"stdout\"");
            }
        }
    }
}