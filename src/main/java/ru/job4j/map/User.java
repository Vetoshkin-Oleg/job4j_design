package ru.job4j.map;

import java.util.*;

public class User {
    private final String name;
    private final int children;
    private final Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @SuppressWarnings("checkstyle:EqualsHashCode")
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2017, Calendar.JANUARY, 25);
        calendar.set(Calendar.HOUR, 19);
        calendar.set(Calendar.MINUTE, 42);
        calendar.set(Calendar.SECOND, 12);
        calendar.set(Calendar.MILLISECOND, 37);

        User user1 = new User("Ivan", 5, calendar);
        User user2 = new User("Ivan", 5, calendar);

        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());

        int hashCode1 = user1.hashCode();
        int hashCode2 = user2.hashCode();
        int hash1 = hashCode1 ^ (hashCode1 >>> 16);
        int hash2 = hashCode2 ^ (hashCode2 >>> 16);
        int bucket1 = hash1 & 15;
        int bucket2 = hash2 & 15;

        map.entrySet()
                .forEach(System.out::println);

        System.out.println(bucket1 + " bucket1");
        System.out.println(bucket2 + " bucket2");

    }
}