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
    private static List<String> columns = new ArrayList<>();

    public static void handle(ArgsName argsName) throws IOException {
        sourceFile = Path.of(argsName.get("path"));
        delimiter = argsName.get("delimiter");
        out = argsName.get("out");
        filter = argsName.get("filter");
        checkArguments();
        filterColumn(sourceFile);
        List<String> content = readFile(sourceFile);

        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < content.size(); row++) {
            String[] temp = content.get(row).split(delimiter);
            for (int column = 0; column < selectedColumns.size(); column++) {
                int index = columns.indexOf(selectedColumns.get(column));
                stringBuilder.append(temp[index]);
                stringBuilder.append(delimiter);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            if (row != columns.size() - 1) {
                stringBuilder.append(System.lineSeparator());
            }
        }
        print(stringBuilder.toString(), out);
    }

    private static void filterColumn(Path path) throws IOException {
        var scanner = new Scanner(path);
        String headLine = scanner.nextLine();
        headLine = headLine.substring(1, headLine.length() - 1);
        columns = List.of(headLine.split(delimiter));
        selectedColumns.addAll(Arrays.asList(filter.split(",")));
        if (!new HashSet<>(columns).containsAll(selectedColumns)) {
            throw new IllegalArgumentException("Четвертый аргумент командной строки введен некорректно: "
                    + "не все значения параметра \"filter\" входят в список заголовков всех столбцов файла");
        }
    }

    private static void print(String data, String out) {
        if ("stdout".equals(out)) {
            System.out.println(data);
        } else {
            try (PrintWriter pw = new PrintWriter(new FileWriter(out, false))) {
                pw.println(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> readFile(Path path) throws IOException {
        List<String> result = new ArrayList<>();
        var scanner = new Scanner(path);
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            string = string.substring(1, string.length() - 1);
            result.add(string);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            throw new IllegalArgumentException("Количество аргументов командной строки должно быть равно 4");
        }
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
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