package ru.job4j.ood.lsp.productstorage;

import ru.job4j.ood.lsp.productstorage.food.Food;
import ru.job4j.ood.lsp.productstorage.store.Store;

import java.time.LocalDate;
import java.util.List;

public class ControlQuality {
    private final Food food;
    private final LocalDate currentDate;

    public ControlQuality(Food food, LocalDate currentDate) {
        this.food = food;
        this.currentDate = currentDate;
    }

    public void distributionOfProducts(List<Store> stores) {
        RemainingTime.calculationOfRemainingTime(food, currentDate);
        for (Store s : stores) {
            if (s.add(food)) {
                break;
            }
        }
    }
}