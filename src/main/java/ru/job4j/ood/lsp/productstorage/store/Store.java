package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.food.Food;

public interface Store {
    boolean add(Food food);

    boolean remove(Food food);

    double getLowerLimit();

    double getUpperLimit();

    void addByName(String nameStore, Food food);
}