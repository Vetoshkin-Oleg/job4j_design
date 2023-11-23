package ru.job4j.ood.lsp.productstorage.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.productstorage.RemainingTime;
import ru.job4j.ood.lsp.productstorage.food.Food;
import ru.job4j.ood.lsp.productstorage.food.Milk;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.*;

class WarehouseTest {

    @Test
    void addWhen22NovThenTrue() {
        LocalDate createDate = LocalDate.of(2023, Month.NOVEMBER, 22);
        LocalDate currentDate = LocalDate.of(2023, Month.NOVEMBER, 22);
        LocalDate expiryDate = createDate.plusDays(8);
        Food milk = new Milk("milk", expiryDate, createDate, 100, 0);
        Store warehouse = new Warehouse();
        RemainingTime.calculationOfRemainingTime(milk, currentDate);
        assertThat(warehouse.add(milk)).isTrue();
        assertThat(warehouse.getFoodList()).contains(milk);
    }

    @Test
    void addWhen23NovThenTrue() {
        LocalDate createDate = LocalDate.of(2023, Month.NOVEMBER, 22);
        LocalDate currentDate = LocalDate.of(2023, Month.NOVEMBER, 23);
        LocalDate expiryDate = createDate.plusDays(8);
        Food milk = new Milk("milk", expiryDate, createDate, 100, 0);
        Store warehouse = new Warehouse();
        RemainingTime.calculationOfRemainingTime(milk, currentDate);
        assertThat(warehouse.add(milk)).isTrue();
        assertThat(warehouse.getFoodList()).contains(milk);
    }

    @Test
    void addWhen24NovThenFalse() {
        LocalDate createDate = LocalDate.of(2023, Month.NOVEMBER, 22);
        LocalDate currentDate = LocalDate.of(2023, Month.NOVEMBER, 24);
        LocalDate expiryDate = createDate.plusDays(8);
        Food milk = new Milk("milk", expiryDate, createDate, 100, 0);
        Store warehouse = new Warehouse();
        RemainingTime.calculationOfRemainingTime(milk, currentDate);
        assertThat(warehouse.add(milk)).isFalse();
        assertThat(warehouse.getFoodList()).doesNotContain(milk);
    }
}