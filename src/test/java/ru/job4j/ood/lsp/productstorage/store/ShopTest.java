package ru.job4j.ood.lsp.productstorage.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.productstorage.RemainingTime;
import ru.job4j.ood.lsp.productstorage.food.Food;
import ru.job4j.ood.lsp.productstorage.food.Milk;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.*;

class ShopTest {

    @Test
    void addWhen30NovThenFalse() {
        LocalDate createDate = LocalDate.of(2023, Month.NOVEMBER, 22);
        LocalDate currentDate = LocalDate.of(2023, Month.NOVEMBER, 30);
        LocalDate expiryDate = createDate.plusDays(8);
        Food milk = new Milk("milk", expiryDate, createDate, 100, 0);
        Store shop = new Shop();
        RemainingTime.calculationOfRemainingTime(milk, currentDate);
        assertThat(shop.add(milk)).isFalse();
        assertThat(shop.getFoodList()).doesNotContain(milk);
    }

    @Test
    void addWhen29NovThenDiscount() {
        LocalDate createDate = LocalDate.of(2023, Month.NOVEMBER, 22);
        LocalDate currentDate = LocalDate.of(2023, Month.NOVEMBER, 29);
        LocalDate expiryDate = createDate.plusDays(8);
        Food milk = new Milk("milk", expiryDate, createDate, 100, 0);
        Store shop = new Shop();
        RemainingTime.calculationOfRemainingTime(milk, currentDate);
        assertThat(shop.add(milk)).isTrue();
        assertThat(shop.getFoodList()).contains(milk);
        assertThat(shop.getFoodList().get(0).getPrice()).isEqualTo(80);
    }

    @Test
    void addWhen28NovThenNotDiscount() {
        LocalDate createDate = LocalDate.of(2023, Month.NOVEMBER, 22);
        LocalDate currentDate = LocalDate.of(2023, Month.NOVEMBER, 28);
        LocalDate expiryDate = createDate.plusDays(8);
        Food milk = new Milk("milk", expiryDate, createDate, 100, 0);
        Store shop = new Shop();
        RemainingTime.calculationOfRemainingTime(milk, currentDate);
        assertThat(shop.add(milk)).isTrue();
        assertThat(shop.getFoodList()).contains(milk);
        assertThat(shop.getFoodList().get(0).getPrice()).isEqualTo(100);
    }

    @Test
    void addWhen24NovThenTrue() {
        LocalDate createDate = LocalDate.of(2023, Month.NOVEMBER, 22);
        LocalDate currentDate = LocalDate.of(2023, Month.NOVEMBER, 24);
        LocalDate expiryDate = createDate.plusDays(8);
        Food milk = new Milk("milk", expiryDate, createDate, 100, 0);
        Store shop = new Shop();
        RemainingTime.calculationOfRemainingTime(milk, currentDate);
        assertThat(shop.add(milk)).isTrue();
        assertThat(shop.getFoodList()).contains(milk);
        assertThat(shop.getFoodList().get(0).getPrice()).isEqualTo(100);
    }

    @Test
    void addWhen23NovThenFalse() {
        LocalDate createDate = LocalDate.of(2023, Month.NOVEMBER, 22);
        LocalDate currentDate = LocalDate.of(2023, Month.NOVEMBER, 23);
        LocalDate expiryDate = createDate.plusDays(8);
        Food milk = new Milk("milk", expiryDate, createDate, 100, 0);
        Store shop = new Shop();
        RemainingTime.calculationOfRemainingTime(milk, currentDate);
        assertThat(shop.add(milk)).isFalse();
        assertThat(shop.getFoodList()).doesNotContain(milk);
    }
}