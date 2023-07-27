package ru.job4j.spammer;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {

    private final Properties cfg;
    private final String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            String line;
            while ((line = rd.readLine()) != null) {
                line = line.trim();
                String[] temp = checkLine(line);
                users.add(new User(temp[0], temp[1]));
            }
        }
        return users;
    }

    private String[] checkLine(String line) {
        String[] result;
        if (line.endsWith(";")) {
            line = line.substring(0, line.length() - 1);
        }
        if (!line.contains(";")) {
            throw new IllegalArgumentException("Missing semicolon!");
        }
        result = line.split(";", 2);
        if (result.length != 2
                || result[0].isEmpty()
                || result[1].isEmpty()) {
            throw new IllegalArgumentException("Invalid string!");
        }
        return result;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) { try (Statement statement = cnt.createStatement()) {
                String sql = String.format(
                        "CREATE TABLE IF NOT EXISTS demo_table(%s, %s, %s);",
                        "id SERIAL PRIMARY KEY",
                        "name TEXT",
                        "email TEXT"
                );
                statement.execute(sql);
            }

            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement
                        ("INSERT INTO demo_table(name, email) VALUES (?, ?)")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (InputStream in = ImportDB.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "./data/dump.txt");
        db.save(db.load());
    }
}