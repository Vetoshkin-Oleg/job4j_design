package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.food.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    private final Food food;
    List<Food> foodList = new ArrayList<>();

    public AbstractStore(Food food) {
        this.food = food;
    }

    @Override
    public boolean add(Food food) {
        foodList.add(food);
        return true;
    }

    @Override
    public boolean remove(Food food) {
        foodList.remove(food);
        return true;
    }

    public Food getFood() {
        return food;
    }

    public List<Food> getFoodList() {
        return foodList;
    }
}