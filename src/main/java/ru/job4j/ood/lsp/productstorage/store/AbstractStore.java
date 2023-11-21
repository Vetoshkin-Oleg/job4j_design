package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.food.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    List<Food> foodList = new ArrayList<>();
    private List<Store> stores;

    @Override
    public boolean add(Food food) {
        foodList.add(food);
        return true;
    }

    @Override
    public boolean remove(Food food) {
        foodList.remove(food);
        return true;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    @Override
    public void addByName(String nameStore, Food food) {
        System.out.println(nameStore);
        switch (nameStore) {
            case ("Trash") -> {
                Trash trash = new Trash();
                trash.add(food);
            }
            case ("Shop") -> {
                Shop shop = new Shop();
                shop.add(food);
            }
            case ("Warehouse") -> {
                Warehouse warehouse = new Warehouse();
                warehouse.add(food);
            }
            default -> {
                System.out.println("Ошибка в имени хранилища");
            }
        }
    }
}