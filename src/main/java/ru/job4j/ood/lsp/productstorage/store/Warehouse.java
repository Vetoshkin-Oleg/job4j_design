package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.food.Food;

public class Warehouse extends AbstractStore {
    private Food food;

    public boolean add(Food food) {
        System.out.println("Товар добавлен в Warehouse");
        foodList.add(food);
        return true;
    }

    public boolean remove(Food food) {
        System.out.println("Товар удален из Warehouse");
        foodList.remove(food);
        return true;
    }

    public double getLowerLimit() {
        return 0.75;
    }

    public double getUpperLimit() {
        return 1.00;
    }

    @Override
    public String toString() {
        return "Warehouse{"
                + "food=" + food
                + ", foodList=" + foodList
                + '}';
    }
}