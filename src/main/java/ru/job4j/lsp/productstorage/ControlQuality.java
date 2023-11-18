package ru.job4j.lsp.productstorage;

import ru.job4j.lsp.productstorage.food.Food;
import ru.job4j.lsp.productstorage.store.Store;

public class ControlQuality {
    private final Store store;
    private final Food food;

    public ControlQuality(Store store, Food food) {
        this.store = store;
        this.food = food;
    }
}
