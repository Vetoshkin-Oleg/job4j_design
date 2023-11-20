package ru.job4j.ood.lsp.productstorage;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.productstorage.food.Food;
import ru.job4j.ood.lsp.productstorage.food.Milk;
import ru.job4j.ood.lsp.productstorage.store.Store;
import ru.job4j.ood.lsp.productstorage.store.Warehouse;

import java.time.LocalDate;
import java.time.Month;

class ControlQualityTest {
   @Test
   public void distributionOfProducts() {
      Store store;
      LocalDate createDate = LocalDate.now();
      LocalDate expiryDate = createDate.plusDays(8);
      Food milk1 = new Milk("milk1", expiryDate, createDate, 120, 0);
//      Food milk2 = new Milk("milk2", expiryDate, createDate, 120, 0);
//      Food milk3 = new Milk("milk3", expiryDate, createDate, 120, 0);
      ControlQuality controlQuality1 = new ControlQuality(milk1);
//      ControlQuality controlQuality2 = new ControlQuality(milk2);
//      ControlQuality controlQuality3 = new ControlQuality(milk3);
      LocalDate currentDate1 = LocalDate.of(2023, Month.NOVEMBER, 20);
//      LocalDate currentDate2 = LocalDate.of(2023, Month.NOVEMBER, 21);
//      LocalDate currentDate3 = LocalDate.of(2023, Month.NOVEMBER, 22);
      controlQuality1.distributionOfProducts(currentDate1);
//      controlQuality2.distributionOfProducts(currentDate2);
//      controlQuality3.distributionOfProducts(currentDate3);
      store = new Warehouse(milk1);
//      assertThat(store.getFoodList().contains("milk1"));
//      assertThat(store.getFoodList().contains("milk2"));
      System.out.println(store.getFoodList());
//      assertThat(store.getFoodList().contains("milk3"));
   }
}