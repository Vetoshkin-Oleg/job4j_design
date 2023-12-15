package ru.job4j.ood.lsp.parking.store;

import java.util.HashMap;
import java.util.Map;

public class CarsRecords {
    enum TypeParking {
        CAR_PARKING,
        TRUCK_PARKING
    }

    private static final Map<String, TypeParking> carsRecords = new HashMap<>();

    public static Map<String, TypeParking> getCarsRecords() {
        return carsRecords;
    }

    public static void setCarsRecords(String name, TypeParking typeParking) {
        CarsRecords.carsRecords.put(name, typeParking);
    }
}
