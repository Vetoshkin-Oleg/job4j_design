package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.food.Food;

public class Trash extends AbstractStore {
    private final Food food;

    public Trash(Food food) {
        super(food);
        this.food = food;
    }
}
