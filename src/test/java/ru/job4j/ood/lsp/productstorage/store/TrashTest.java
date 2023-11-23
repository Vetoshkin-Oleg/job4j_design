package ru.job4j.ood.lsp.productstorage.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.productstorage.RemainingTime;
import ru.job4j.ood.lsp.productstorage.food.Food;
import ru.job4j.ood.lsp.productstorage.food.Milk;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class TrashTest {

    @Test
    void addWhen29NovThenFalse() {
        LocalDate createDate = LocalDate.of(2023, Month.NOVEMBER, 22);
        LocalDate currentDate = LocalDate.of(2023, Month.NOVEMBER, 29);
        LocalDate expiryDate = createDate.plusDays(8);
        Food milk = new Milk("milk", expiryDate, createDate, 100, 0);
        Store trash = new Trash();
        RemainingTime.calculationOfRemainingTime(milk, currentDate);
        assertThat(trash.add(milk)).isFalse();
        assertThat(trash.getFoodList()).doesNotContain(milk);
    }

    @Test
    void addWhen30NovThenTrue() {
        LocalDate createDate = LocalDate.of(2023, Month.NOVEMBER, 22);
        LocalDate currentDate = LocalDate.of(2023, Month.NOVEMBER, 30);
        LocalDate expiryDate = createDate.plusDays(8);
        Food milk = new Milk("milk", expiryDate, createDate, 100, 0);
        Store trash = new Trash();
        RemainingTime.calculationOfRemainingTime(milk, currentDate);
        assertThat(trash.add(milk)).isTrue();
        assertThat(trash.getFoodList()).contains(milk);
    }
}