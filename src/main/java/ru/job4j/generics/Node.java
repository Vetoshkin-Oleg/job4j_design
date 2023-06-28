package ru.job4j.generics;

public class Node<T> {
    private final T data;
    private final Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }
}