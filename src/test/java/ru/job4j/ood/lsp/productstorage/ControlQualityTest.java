package ru.job4j.ood.lsp.productstorage;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.productstorage.food.Food;
import ru.job4j.ood.lsp.productstorage.food.Milk;
import ru.job4j.ood.lsp.productstorage.store.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

class ControlQualityTest {

    @Test
    public void distributionOfProducts() {
        LocalDate createDate = LocalDate.of(2023, Month.NOVEMBER, 22);
        LocalDate currentDate = LocalDate.of(2023, Month.NOVEMBER, 29);
        LocalDate expiryDate = createDate.plusDays(8);
        Food milk = new Milk("milk", expiryDate, createDate, 100, 0);
        Store shop = new Shop();
        Store warehouse = new Warehouse();
        Store trash = new Trash();
        List<Store> store = Arrays.asList(shop, warehouse, trash);
        ControlQuality controlQuality = new ControlQuality(store, milk, currentDate);
        controlQuality.distributionOfProducts();
    }
}