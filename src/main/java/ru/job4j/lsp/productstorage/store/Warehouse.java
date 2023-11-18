package ru.job4j.lsp.productstorage.store;

import ru.job4j.lsp.productstorage.food.Food;

public class Warehouse extends AbstractStore {
    private final Food food;

    public Warehouse(Food food) {
        super(food);
        this.food = food;
    }
}