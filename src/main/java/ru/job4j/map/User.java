package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private final String name;
    private final int children;
    private final Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User user1 = new User("Ivan", 5,
                new GregorianCalendar(2017, Calendar.JANUARY, 25));
        User user2 = new User("Ivan", 5,
                new GregorianCalendar(2017, Calendar.JANUARY, 25));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());

        map.entrySet()
                .forEach(System.out::println);

        int hashCode1 = user1.hashCode();
        int hashCode2 = user2.hashCode();
        int hash1 = hashCode1 ^ (hashCode1 >>> 16);
        int hash2 = hashCode2 ^ (hashCode2 >>> 16);
        int bucket1 = hash1 & 15;
        int bucket2 = hash2 & 15;

        for (int i = 0; i < 2147483647; i++) {
            if (bucket1 == bucket2) {
                System.out.println(bucket1 + " bucket1");
                System.out.println(bucket2 + " bucket2");
            }
        }

    }
}