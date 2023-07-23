package ru.job4j.ood.lsp;

public class Dog extends Animal {
    private final String sound = "woof";
    public void sound() {
        super.sound(sound);
    }
}