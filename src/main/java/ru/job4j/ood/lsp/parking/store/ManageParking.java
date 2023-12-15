package ru.job4j.ood.lsp.parking.store;

import ru.job4j.ood.lsp.parking.transport.Transport;

public interface ManageParking {
    boolean takePlace(Transport transport);

    boolean freePlace(Transport transport);
}