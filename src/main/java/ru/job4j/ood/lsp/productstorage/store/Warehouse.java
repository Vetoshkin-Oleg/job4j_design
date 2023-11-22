package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.food.Food;

import java.time.temporal.ChronoUnit;

public class Warehouse extends AbstractStore {
    private Food food;

    @Override
    public boolean checkRemaining(Food food) {
        long totalShelfLife = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        return (double) food.getRemainingTime() / totalShelfLife > 0.75;
    }

    @Override
    public String toString() {
        return "Warehouse{"
                + "food=" + food
                + ", foodList=" + foodList
                + '}';
    }
}