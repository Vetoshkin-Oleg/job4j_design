package ru.job4j.ood.lsp;
/*Нарушение заключается в том, что метод программы зависит от конкретной реализации наследника.
* А при изменении наследников - придется дорабатывать метод, чтобы птица издавала свой звук,
* а не гавкала и не мяукала. */

public class Animal {
    public void sound(String sound) {
        if ("woof".equals(sound)) {
            System.out.println("The dog barking");
        } else {
            System.out.println("The cat meows");
        }
    }
}
