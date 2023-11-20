package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.food.Food;

public class Trash extends AbstractStore {
    private final Food food;

    public Trash(Food food) {
        super(food);
        this.food = food;
    }

    public boolean add(Food food) {
        System.out.println("Товар добавлен в Trash");
        foodList.add(food);
        return true;
    }

    public boolean remove(Food food) {
        System.out.println("Товар удален из Trash");
        foodList.remove(food);
        return true;
    }

    @Override
    public String toString() {
        return "Trash{"
                + "food=" + food
                + ", foodList=" + foodList
                + '}';
    }
}
