package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.io.*;

public class Emulator {
    static DirFileCache dirFileCache = null;

    public static void showMenu() {
        while (true) {
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
                        BufferedReader bufferedReaderDir = new BufferedReader(new InputStreamReader(System.in));
                        String cashDir = bufferedReaderDir.readLine();
                        dirFileCache = new DirFileCache(cashDir);
                    }
                    case 2 -> {
                        System.out.print("указать имя файла: ");
                        BufferedReader bufferedReaderFileName = new BufferedReader(new InputStreamReader(System.in));
                        String fileName = bufferedReaderFileName.readLine();
                        String value = dirFileCache.get(fileName);
                        dirFileCache.put(fileName, value);
                    }
                    case 3 -> {
                        System.out.print("указать имя файла: ");
                        BufferedReader bufferedReaderFileName = new BufferedReader(new InputStreamReader(System.in));
                        String fileName = bufferedReaderFileName.readLine();
                        String value = dirFileCache.get(fileName);
                        System.out.println(value);
                    }
                    case 4 -> System.exit(0);
                    default -> throw new NumberFormatException();
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Введите целое число 1..4");
            }
        }
    }

    public static void main(String[] args) {
        showMenu();
    }
}