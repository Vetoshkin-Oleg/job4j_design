package ru.job4j.lsp.productstorage.store;

import ru.job4j.lsp.productstorage.food.Food;

public interface Store {
    boolean add(Food food);

    boolean remove(Food food);
}