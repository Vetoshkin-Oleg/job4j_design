package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.food.Food;

public class Shop extends AbstractStore {
    private final Food food;

    public Shop(Food food) {
        super(food);
        this.food = food;
    }

    public boolean add(Food food) {
        boolean rsl = false;
        if (super.add(food)) {
            System.out.println("Товар добавлен в Shop");
            rsl = true;
        }
        return rsl;
    }

    public boolean remove(Food food) {
        boolean rsl = false;
        if (super.remove(food)) {
            System.out.println("Товар удален из Shop");
            rsl = true;
        }
        return rsl;
    }

    @Override
    public String toString() {
        return "Shop{"
                + "food=" + food
                + ", foodList=" + foodList
                + '}';
    }
}