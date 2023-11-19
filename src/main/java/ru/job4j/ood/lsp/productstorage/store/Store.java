package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.food.Food;

import java.util.List;

public interface Store {
    boolean add(Food food);

    boolean remove(Food food);

    public List<Food> getFoodList();
}