package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.food.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    protected List<Food> foodList = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean result = false;
        if (checkRemaining(food)) {
            foodList.add(food);
            result = true;
        }
        return result;
    }

    @Override
    public boolean remove(Food food) {
        foodList.remove(food);
        return true;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}