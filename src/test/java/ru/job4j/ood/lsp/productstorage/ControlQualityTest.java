package ru.job4j.ood.lsp.productstorage;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.productstorage.food.Food;
import ru.job4j.ood.lsp.productstorage.food.Milk;
import ru.job4j.ood.lsp.productstorage.store.AbstractStore;
import ru.job4j.ood.lsp.productstorage.store.Store;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {
   @Test
   public void distributionOfProducts() {
      LocalDate createDate = LocalDate.now();
      LocalDate expiryDate = createDate.plusDays(4);
      Food milk = new Milk("milk", expiryDate, createDate, 120, 0);
      Store store = null;
      ControlQuality controlQuality = new ControlQuality(store, milk);
      controlQuality.distributionOfProducts();
   }
}