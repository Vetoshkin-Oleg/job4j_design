package ru.job4j.ood.dip;

import java.util.*;

public class SimpleShopService {

    private final HashMap<User, Set<Order>> serviceDB = new HashMap<>();

    public boolean createBucket(User user) {
        if (serviceDB.containsKey(user)) {
            return false;
        }
        return serviceDB.put(user, new HashSet<>()) != null;
    }

    public boolean createOrder(User user, Order order) {
        Set<Order> orders = serviceDB.getOrDefault(user, Set.of());
        if (orders.isEmpty()) {
            return false;
        }
        return orders.add(order);
    }

    public boolean addProduct(User user, Order order, Product product) {
        Optional<Order> orderDB = findOrder(user, order);
        return orderDB.map(value -> value.add(product)).orElse(false);
    }

    private Optional<Order> findOrder(User user, Order order) {
        return serviceDB.getOrDefault(user, Set.of()).stream()
                .filter(o -> o.getId() == order.getId())
                .findFirst();
    }

    public boolean removeProduct(User user, Order order, Product product) {
        Optional<Order> orderDB = findOrder(user, order);
        return orderDB.map(value -> value.remove(product.getId())).orElse(false);
    }

    public boolean removeOrder(User user, Order order) {
        Set<Order> orders = serviceDB.get(user);
        if (orders == null) {
            return false;
        }
        return orders.remove(order);
    }

    public Check payOrder(User user, Order order) {
        Optional<Order> orderDB = findOrder(user, order);
        if (orderDB.isEmpty()) {
            System.out.println("Get error with " + user + " " + order);
            throw new IllegalArgumentException("Invalid order");
        }
        if (orderDB.get().isPayed()) {
            System.out.println("Get error with "  + user + " " + order);
            throw new IllegalArgumentException("Already payed!");
        }
        orderDB.get().setPayed(true);
        return new Check((int) (System.currentTimeMillis() % 1000_000), "Payed: " + orderDB.get().getId());
    }

}