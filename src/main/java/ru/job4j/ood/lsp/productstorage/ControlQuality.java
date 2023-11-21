package ru.job4j.ood.lsp.productstorage;

import ru.job4j.ood.lsp.productstorage.food.Food;
import ru.job4j.ood.lsp.productstorage.store.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ControlQuality {
    private final List<Store> stores;
    private final Food food;
    private final LocalDate currentDate;

    public ControlQuality(List<Store> stores, Food food, LocalDate currentDate) {
        this.stores = stores;
        this.food = food;
        this.currentDate = currentDate;
    }

    public void distributionOfProducts() {
        long productSalesPeriod = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        long timeLeft = ChronoUnit.DAYS.between(currentDate, food.getExpiryDate());
        System.out.println(productSalesPeriod);
        System.out.println(timeLeft);
        for (Store s : stores) {
            if (s.getUpperLimit() == 0) {
                System.out.println("trash");
                int dotIndex = s.getClass().getName().lastIndexOf('.') + 1;
                String nameStore = s.getClass().getName().substring(dotIndex);
                s.addByName(nameStore, food);
            }
        }
    }

    /*public void distributionOfProducts(LocalDate currentDate) {
        long productSalesPeriod = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        long timeLeft = ChronoUnit.DAYS.between(currentDate, food.getExpiryDate());
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
    }*/
}