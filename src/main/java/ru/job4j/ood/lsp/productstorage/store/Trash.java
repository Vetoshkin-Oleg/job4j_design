package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.food.Food;

public class Trash extends AbstractStore {
    private Food food;

    @Override
    public boolean add(Food food) {
        System.out.println("Попытка добавления в Trash");
        return super.add(food);
    }

    public boolean checkRemaining(Food food) {
        return food.getRemainingTime() == 0;
    }

    @Override
    public String toString() {
        return "Trash{"
                + "food=" + food
                + ", foodList=" + foodList
                + '}';
    }
}