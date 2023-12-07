package ru.job4j.ood.lsp.parking.store;

import ru.job4j.ood.lsp.parking.transport.Transport;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements ManageParking {
    private final double[] carCapacity;
    private final double[] truckCapacity;
    private boolean flag = false;
    private Map<Integer, Double> carsFill = new HashMap<>();
    private Map<String, Map<Integer, Double>> mapCars = new HashMap<>();

    public ParkingLot(double carSpots, double trackSpots) {
        carCapacity = new double[(int) carSpots];
        truckCapacity = new double[(int) trackSpots];
    }

    @Override
    public boolean takePlace(Transport transport) {
        boolean result = false;
        if (!checkParking(transport)) {
            return result;
        }
        if ("Car".equals(determineType(transport))) {
            result = fillAttempt(transport, carCapacity);
        } else if ("Truck".equals(determineType(transport))) {
            result = fillAttempt(transport, truckCapacity);
            if (!result) {
                result = fillAttempt(transport, carCapacity);
            }
        }
        return result;
    }

    private double currentValueSpots(double[] parkingCapacity) {
        return Arrays.stream(parkingCapacity).sum();
    }

    private String determineType(Transport transport) {
        if ("Car".equals(transport.getType())) {
            return "Car";
        } else if ("Truck".equals(transport.getType())) {
            return "Truck";
        }
        return "Error";
    }

    private boolean checkParking(Transport transport) {
        if ("Car".equals(determineType(transport))) {
            return currentValueSpots(carCapacity) + transport.getWidth() <= carCapacity.length;
        } else if ("Truck".equals(determineType(transport))) {
            double currentSpots = currentValueSpots(carCapacity) + currentValueSpots(truckCapacity);
            return currentSpots + transport.getWidth() <= (carCapacity.length + truckCapacity.length);
        }
        return false;
    }

    private boolean fillAttempt(Transport transport, double[] parkingCapacity) {
        boolean result = false;
        int needSpots = (int) Math.ceil(transport.getWidth());
        for (int i = 0; i <= (parkingCapacity.length - needSpots); i++) {
            if (parkingCapacity[i] < 1) {
                double[] parkingAttempt = Arrays.copyOfRange(parkingCapacity, i, i + needSpots);
                result = parkingAttemptMeth(transport, parkingAttempt);
                if (!result) {
                    parkingAttempt = Arrays.copyOfRange(parkingCapacity, i, i + needSpots + 1);
                    result = parkingAttemptMeth(transport, parkingAttempt);
                    flag = true;
                }
                if (result) {
                    fillParking(parkingCapacity, needSpots, i, transport.getWidth());
                    break;
                }
            }
        }
        return result;
    }

    private void fillParking(double[] parkingCapacity, int needSpots, int start, double getWidth) {
        if (flag) {
            needSpots++;
        }
        for (int i = start; i < start + needSpots; i++) {
            double difference = 1 - parkingCapacity[i];
            parkingCapacity[i] = parkingCapacity[i] + difference;
            getWidth = getWidth - difference;
            if (getWidth < 1) {
                break;
            }
        }
        if (getWidth != 0) {
            parkingCapacity[start + needSpots - 1] = getWidth + parkingCapacity[start + needSpots - 1];
        }
    }

    private boolean parkingAttemptMeth(Transport transport, double[] parkingCapacity) {
        return transport.getWidth() + currentValueSpots(parkingCapacity) <= parkingCapacity.length;
    }

    @Override
    public boolean freePlace(Transport transport) {
        System.out.println(carCapacity[0]);
        System.out.println(carCapacity[1]);
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