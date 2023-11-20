package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.food.Food;

public class Shop extends AbstractStore {
    private final Food food;

    public Shop(Food food) {
        super(food);
        this.food = food;
    }

    public boolean add(Food food) {
        System.out.println("Товар добавлен в Shop");
        foodList.add(food);
        return true;
    }

    public boolean remove(Food food) {
        System.out.println("Товар удален из Shop");
        foodList.remove(food);
        return true;
    }

    @Override
    public String toString() {
        return "Shop{"
                + "food=" + food
                + ", foodList=" + foodList
                + '}';
    }
}