package ru.job4j.ood.lsp.productstorage;

import ru.job4j.ood.lsp.productstorage.food.Food;
import ru.job4j.ood.lsp.productstorage.store.Shop;
import ru.job4j.ood.lsp.productstorage.store.Store;

import java.time.LocalDate;
import java.time.Month;

public class ControlQuality {
    private Store store;
    private final Food food;
    LocalDate currentDate = LocalDate.of(2023, Month.NOVEMBER, 21);
//    dd-MM-yyyy

    public ControlQuality(Store store, Food food) {
        this.store = store;
        this.food = food;
    }

    public void distributionOfProducts() {
        System.out.println(currentDate);
        System.out.println(food.getName());
        store = new Shop(food);
        store.add(food);
        System.out.println(store.getFoodList());
    }
}