package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.io.*;

public class Emulator {
    static DirFileCache dirFileCache = null;

    private static void showMenu() {
        boolean run = true;
        while (run) {
            System.out.printf("%s%s%s%s%s%s%s%n%n",
                    "1 - указать кэшируемую директорию", System.lineSeparator(),
                    "2 - загрузить содержимое файла в кэш", System.lineSeparator(),
                    "3 - получить содержимое файла из кэша", System.lineSeparator(),
                    "4 - выход");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                switch (Integer.parseInt(bufferedReader.readLine())) {
                    case 1 -> {
                        System.out.print("указать кэшируемую директорию: ");
                        dirFileCache = new DirFileCache(workWithCache());
                    }
                    case 2 -> {
                        System.out.print("указать имя файла: ");
                        String fileName = workWithCache();
                        String value = dirFileCache.get(fileName);
                        dirFileCache.put(fileName, value);
                    }
                    case 3 -> {
                        System.out.print("указать имя файла: ");
                        String fileName = workWithCache();
                        String value = dirFileCache.get(fileName);
                        System.out.println(value);
                    }
                    case 4 -> run = false;
                    default -> throw new NumberFormatException();
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Введите целое число 1..4");
            }
        }
    }

    private static String workWithCache() throws IOException {
        String result;
        BufferedReader bufferedReaderDir = new BufferedReader(new InputStreamReader(System.in));
        result = bufferedReaderDir.readLine();
        return result;
    }

    public static void main(String[] args) {
        showMenu();
    }
}