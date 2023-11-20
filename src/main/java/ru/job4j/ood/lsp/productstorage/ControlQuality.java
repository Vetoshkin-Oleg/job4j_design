package ru.job4j.ood.lsp.productstorage;

import ru.job4j.ood.lsp.productstorage.food.Food;
import ru.job4j.ood.lsp.productstorage.store.Shop;
import ru.job4j.ood.lsp.productstorage.store.Store;
import ru.job4j.ood.lsp.productstorage.store.Trash;
import ru.job4j.ood.lsp.productstorage.store.Warehouse;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ControlQuality {
    private Store store;
    private final Food food;

    public ControlQuality(Food food) {
        this.food = food;
    }

    public void distributionOfProducts(LocalDate currentDate) {
        long productSalesPeriod = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        long timeLeft = ChronoUnit.DAYS.between(currentDate, food.getExpiryDate());
        System.out.println(productSalesPeriod);
        System.out.println(timeLeft);
        if ((double) timeLeft / productSalesPeriod > 0.75) {
            System.out.println("Warehouse");
            store = new Warehouse(food);
            store.add(food);
            System.out.println(store.getFoodList() + "Warehouse");
        } else if ((double) timeLeft / productSalesPeriod >= 0.25
                && (double) timeLeft / productSalesPeriod <= 0.75) {
            System.out.println("Shop");
            store = new Shop(food);
            store.add(food);
            System.out.println(store.getFoodList() + "Shop");
        } else if ((double) timeLeft / productSalesPeriod < 0.25
                && (double) timeLeft / productSalesPeriod > 0) {
            System.out.println("discount");
            food.setPrice(food.getPrice() * 0.8);
            store = new Shop(food);
            store.add(food);
            System.out.println(store.getFoodList() + "discount");
        } else {
            System.out.println("trash");
            store = new Trash(food);
            store.add(food);
            System.out.println(store.getFoodList() + "trash");
        }
    }
}