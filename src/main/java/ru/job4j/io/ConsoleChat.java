package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() throws IOException {
        List<String> phraseBot = readPhrases();
        List<String> log = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        boolean pause = false;
        while (!OUT.equals(title)) {
            log.add(title);
            int index = (int) (Math.random() * phraseBot.size());
            switch (title) {
                case STOP -> {
                    pause = true;
                }
                case CONTINUE -> {
                    pause = false;
                    if (!pause) {
                        System.out.println(phraseBot.get(index));
                    }
                    log.add(phraseBot.get(index));
                }
                default -> {
                    if (!pause) {
                        System.out.println(phraseBot.get(index));
                        log.add(phraseBot.get(index));
                    }
                    title = scanner.nextLine();
                    continue;
                }
            }
            title = scanner.nextLine();
        }
        log.add(title);
        saveLog(log);
    }

    private List<String> readPhrases() throws IOException {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isBlank()) {
                    result.add(line);
                }
            }
        }
        return result;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path,
                StandardCharsets.UTF_8, true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat("./data/text.txt", "./data/botAnswer.txt");
        cc.run();
    }

}