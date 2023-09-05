package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CSVReader {

    public static void handle(ArgsName argsName) throws IOException {
        Path sourceFile = Path.of(argsName.get("path"));
        String delimiter = argsName.get("delimiter");
        String out = argsName.get("out");
        String filter = argsName.get("filter");
        checkArguments(argsName);
        final List<String> select = filterColumn(sourceFile, delimiter, filter);
        List<String> columns = List.of((readFile(sourceFile).get(0)).split(delimiter));
        List<String> content = readFile(sourceFile);

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : content) {
            String[] temp = s.split(delimiter);
            for (String selectedColumn : select) {
                int index = columns.indexOf(selectedColumn);
                stringBuilder.append(temp[index]);
                stringBuilder.append(delimiter);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append(System.lineSeparator());
        }
        print(stringBuilder.toString(), out);
    }

    private static List<String> filterColumn(Path path, String delimiter, String filter) throws IOException {
        List<String> select;
        try (var scanner = new Scanner(path)) {
            String headLine = scanner.nextLine();
            List<String> columns = List.of(headLine.split(delimiter));
            select = new ArrayList<>(Arrays.asList(filter.split(",")));
            if (!new HashSet<>(columns).containsAll(select)) {
                throw new IllegalArgumentException("Четвертый аргумент командной строки введен некорректно: "
                        + "не все значения параметра \"filter\" входят в список заголовков всех столбцов файла");
            }
        }
        return select;
    }

    private static void print(String data, String out) {
        if ("stdout".equals(out)) {
            System.out.print(data);
        } else {
            try (PrintWriter pw = new PrintWriter(new FileWriter(out, false))) {
                pw.print(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> readFile(Path path) throws IOException {
        List<String> result = new ArrayList<>();
        try (var scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                result.add(string);
            }
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

    private static void checkArguments(ArgsName argsName) {
        Path sourceFile = Path.of(argsName.get("path"));
        String out = argsName.get("out");
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