package ru.job4j.ood.lsp.parking.store;

import ru.job4j.ood.lsp.parking.transport.Transport;

public class ParkingLot implements ManageParking {
    private final double[] carCapacity;
    private final double[] truckCapacity;

    public ParkingLot(double carSpots, double trackSpots) {
        carCapacity = new double[(int) carSpots];
        truckCapacity = new double[(int) trackSpots];
    }

    @Override
    public boolean takePlace(Transport transport) {
        return false;
    }

    @Override
    public boolean freePlace(Transport transport) {
        return false;
    }

    @Override
    public String parkCar(Transport transport) {
        return null;
    }

    public double[] getCarCapacity() {
        return carCapacity;
    }

    public double[] getTruckCapacity() {
        return truckCapacity;
    }
}