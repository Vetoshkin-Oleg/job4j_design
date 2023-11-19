package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.food.Food;

public class Warehouse extends AbstractStore {
    private final Food food;

    public Warehouse(Food food) {
        super(food);
        this.food = food;
    }
}