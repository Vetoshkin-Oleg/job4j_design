package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.food.Food;

import java.time.temporal.ChronoUnit;

public class Shop extends AbstractStore {
    private Food food;

    @Override
    public boolean checkRemaining(Food food) {
        boolean result = false;
        long totalShelfLife = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        double ratioRemainderAndTotalTime = (double) food.getRemainingTime() / totalShelfLife;
        if (ratioRemainderAndTotalTime >= 0.25 && ratioRemainderAndTotalTime <= 0.75) {
            result = true;
        } else if (ratioRemainderAndTotalTime > 0 && ratioRemainderAndTotalTime < 0.25) {
            food.setPrice(food.getPrice() * 0.8);
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Shop{"
                + "food=" + food
                + ", foodList=" + foodList
                + '}';
    }
}