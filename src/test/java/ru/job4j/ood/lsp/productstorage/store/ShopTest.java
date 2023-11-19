package ru.job4j.ood.lsp.productstorage.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.productstorage.food.Food;
import ru.job4j.ood.lsp.productstorage.food.Milk;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static org.assertj.core.api.Assertions.*;

class ShopTest {

    @Test
    void add() {
        LocalDate createDate = LocalDate.now();
        LocalDate expiryDate = createDate.plusDays(4);
        Food milk = new Milk("milk", expiryDate, createDate, 120, 0);
        AbstractStore shop = new Shop(milk);
        System.out.println(createDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        System.out.println(expiryDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        System.out.println(ChronoUnit.DAYS.between(createDate, expiryDate));
        assertThat(shop.add(milk)).isTrue();
    }

    @Test
    void remove() {
        LocalDate createDate = LocalDate.now();
        LocalDate expiryDate = createDate.plusDays(100);
        Food milk = new Milk("milk", expiryDate, createDate, 120, 0);
        Food meat = new Milk("meat", expiryDate, createDate, 400, 0);
    }
}