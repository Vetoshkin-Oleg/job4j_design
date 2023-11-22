package ru.job4j.ood.lsp.productstorage;

import ru.job4j.ood.lsp.productstorage.food.Food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RemainingTime {
    public static void calculationOfRemainingTime(Food food, LocalDate currentDate) {
        long remainingTime = ChronoUnit.DAYS.between(currentDate, food.getExpiryDate());
        if (remainingTime < 0) {
            throw new RuntimeException("Остаток срока годности меньше 0");
        }
        food.setRemainingTime(remainingTime);
    }
}