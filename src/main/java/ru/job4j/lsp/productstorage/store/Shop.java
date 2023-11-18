package ru.job4j.lsp.productstorage.store;

import ru.job4j.lsp.productstorage.food.Food;

public class Shop extends AbstractStore {
    private final Food food;

    public Shop(Food food) {
        super(food);
        this.food = food;
    }
}