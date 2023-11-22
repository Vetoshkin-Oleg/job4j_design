package ru.job4j.ood.lsp.productstorage.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.productstorage.food.Food;
import ru.job4j.ood.lsp.productstorage.food.Milk;

import java.time.LocalDate;

class ShopTest {

    @Test
    void remove() {
        LocalDate createDate = LocalDate.now();
        LocalDate expiryDate = createDate.plusDays(100);
        Food milk = new Milk("milk", expiryDate, createDate, 120, 0);
        Food meat = new Milk("meat", expiryDate, createDate, 400, 0);
    }
}