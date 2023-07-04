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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        User user = (User) obj;
        return (name.equals(user.name)
        && (children == user.children)
        && birthday.getTimeInMillis() == user.birthday.getTimeInMillis());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + children;
        result = 31 * result + birthday.hashCode();
        return result;
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

        int hash1 = user1.hashCode() ^ (user1.hashCode() >>> 16);
        int hash2 = user2.hashCode() ^ (user2.hashCode() >>> 16);
        int bucket1 = hash1 & 15;
        int bucket2 = hash2 & 15;

        map.entrySet()
                .forEach(System.out::println);

        System.out.println(bucket1 + " bucket1");
        System.out.println(bucket2 + " bucket2");
        System.out.println("user1 и user2 одинаковы: " + (user1.equals(user2)));
    }
}