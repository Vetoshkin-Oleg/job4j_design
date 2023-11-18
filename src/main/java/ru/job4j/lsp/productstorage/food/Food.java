package ru.job4j.lsp.productstorage.food;

import java.time.LocalDateTime;

public class Food {
    private final String name;
    private final LocalDateTime expiryDate;
    private final LocalDateTime createDate;
    private final double price;
    private final double discount;

    public Food(String name, LocalDateTime expiryDate, LocalDateTime createDate, double price, double discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }
}