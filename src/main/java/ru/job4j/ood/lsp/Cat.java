package ru.job4j.ood.lsp;

public class Cat extends Animal {
    private final String sound = "meow";
    public void sound() {
        super.sound(sound);
    }
}
