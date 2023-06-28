package ru.job4j.generics;

public class GenericsClass<K, V> {
    private final K key;

    private final V value;

    public GenericsClass(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static void main(String[] args) {
        GenericsClass<String, String> first = new GenericsClass<>("First key", "First value");
        System.out.println("Вывод в консоль: " + first);

        GenericsClass<Integer, String> second = new GenericsClass<>(12345, "Second value");
        System.out.println("Вывод в консоль: " + second);
    }

    @Override
    public String toString() {
        return "GenericsClass{"
                + "key=" + key
                + ", value=" + value
                + '}';
    }
}