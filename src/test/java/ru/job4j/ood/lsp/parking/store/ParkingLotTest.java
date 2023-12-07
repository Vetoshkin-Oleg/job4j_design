package ru.job4j.ood.lsp.parking.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.transport.Car;
import ru.job4j.ood.lsp.parking.transport.Transport;
import ru.job4j.ood.lsp.parking.transport.Truck;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ParkingLotTest {

    @Test
    void takePlaceWhenParkingIsFree() {
        ParkingLot parkingLot = new ParkingLot(3, 5);
        Transport truck = new Truck("truck", 2.73);
        assertThat(parkingLot.takePlace(truck)).isTrue();
        assertThat(parkingLot.getTruckCapacity()[0]).isEqualTo(1);
        assertThat(parkingLot.getTruckCapacity()[1]).isEqualTo(1);
        assertThat(parkingLot.getTruckCapacity()[2]).isEqualTo(0.73);
        assertThat(parkingLot.getTruckCapacity()[3]).isEqualTo(0);
        assertThat(parkingLot.getTruckCapacity()[4]).isEqualTo(0);
        Transport car = new Car("car", 1);
        assertThat(parkingLot.takePlace(car)).isTrue();
        assertThat(parkingLot.getCarCapacity()[0]).isEqualTo(1);
        assertThat(parkingLot.getCarCapacity()[1]).isEqualTo(0);
        assertThat(parkingLot.getCarCapacity()[2]).isEqualTo(0);
    }

    @Test
    void takePlaceWhenParkingIsFull() {
        ParkingLot parkingLot = new ParkingLot(7, 9);
        Transport truck = new Truck("truck", 2.73);
        Transport car = new Car("car", 1);
        Arrays.fill(parkingLot.getTruckCapacity(), 1);
        Arrays.fill(parkingLot.getCarCapacity(), 1);
        assertThat(parkingLot.takePlace(truck)).isFalse();
        assertThat(parkingLot.takePlace(car)).isFalse();
    }

    @Test
    void takePlaceWhenCarParkingIsFull() {
        ParkingLot parkingLot = new ParkingLot(7, 9);
        Transport car = new Car("car", 1);
        Arrays.fill(parkingLot.getCarCapacity(), 1);
        assertThat(parkingLot.takePlace(car)).isFalse();
    }

    @Test
    void takePlaceWhenTruckParkingIsFull() {
        ParkingLot parkingLot = new ParkingLot(7, 9);
        Transport truck = new Truck("truck", 2.73);
        Arrays.fill(parkingLot.getTruckCapacity(), 1);
        assertThat(parkingLot.takePlace(truck)).isTrue();
    }

    @Test
    void takePlaceWhenCarParkingIsBuzyVer1() {
        ParkingLot parkingLot = new ParkingLot(7, 9);
        Transport car = new Car("car", 1);
        Arrays.fill(parkingLot.getCarCapacity(), 1);
        parkingLot.getCarCapacity()[3] = 0;
        assertThat(parkingLot.takePlace(car)).isTrue();
    }

    @Test
    void takePlaceWhenCarParkingIsBuzyVer2() {
        ParkingLot parkingLot = new ParkingLot(7, 9);
        Transport car = new Car("car", 1);
        Arrays.fill(parkingLot.getCarCapacity(), 1);
        parkingLot.getCarCapacity()[2] = 0.5;
        parkingLot.getCarCapacity()[3] = 0.5;
        assertThat(parkingLot.takePlace(car)).isTrue();
        assertThat(parkingLot.getCarCapacity()[2]).isEqualTo(1);
        assertThat(parkingLot.getCarCapacity()[3]).isEqualTo(1);
    }

    @Test
    void takePlaceWhenCarParkingIsBuzyVer3() {
        ParkingLot parkingLot = new ParkingLot(7, 9);
        Transport car = new Car("car", 1);
        Arrays.fill(parkingLot.getCarCapacity(), 1);
        parkingLot.getCarCapacity()[2] = 0.500000000000001;
        /*parkingLot.getCarCapacity()[2] = 0.500000000000000000000000000000000000000000000000000000000000000001;*/
        parkingLot.getCarCapacity()[3] = 0.5;
        assertThat(parkingLot.takePlace(car)).isFalse();
    }

    @Test
    void takePlaceWhenCarParkingIsBuzyVer4() {
        ParkingLot parkingLot = new ParkingLot(7, 9);
        Transport car = new Car("car", 1);
        Arrays.fill(parkingLot.getCarCapacity(), 1);
        parkingLot.getCarCapacity()[2] = 0.000000000000001;
        /*parkingLot.getCarCapacity()[2] = 0.000000000000000000000000000000000000000000000000000000000000000001;
        parkingLot.getCarCapacity()[5] = 0.000000000000000000000000000000000000000000000000000000000000000001;*/
        parkingLot.getCarCapacity()[5] = 0.000000000000001;
        assertThat(parkingLot.takePlace(car)).isFalse();
    }

    @Test
    void freePlaceVer1() {
        ParkingLot parkingLot = new ParkingLot(2, 9);
        Transport car1 = new Car("car1", 1);
        Transport car2 = new Car("car2", 1);
        parkingLot.takePlace(car1);
        parkingLot.takePlace(car2);
        assertThat(parkingLot.freePlace(car1)).isTrue();
        assertThat(parkingLot.getCarCapacity()[0]).isEqualTo(0);
        assertThat(parkingLot.getCarCapacity()[1]).isEqualTo(1);
    }

    @Test
    void freePlaceVer2() {
        ParkingLot parkingLot = new ParkingLot(2, 9);
        Transport car1 = new Car("car1", 1);
        Transport car2 = new Car("car2", 1);
        parkingLot.takePlace(car1);
        parkingLot.takePlace(car2);
        assertThat(parkingLot.freePlace(car2)).isTrue();
        assertThat(parkingLot.getCarCapacity()[0]).isEqualTo(1);
        assertThat(parkingLot.getCarCapacity()[1]).isEqualTo(0);
    }

    @Test
    void freePlaceVer3() {
        ParkingLot parkingLot = new ParkingLot(5, 9);
        Transport truck1 = new Truck("truck1", 3);
        Transport truck2 = new Truck("truck2", 3);
        Transport truck3 = new Truck("truck3", 3);
        parkingLot.takePlace(truck1);
        parkingLot.takePlace(truck2);
        parkingLot.takePlace(truck3);
        Transport car1 = new Car("car1", 1);
        parkingLot.takePlace(car1);
        Transport truck4 = new Truck("truck4", 1.5);
        parkingLot.takePlace(truck4);
        Transport truck5 = new Truck("truck5", 1.5);
        parkingLot.takePlace(truck5);
        Transport car2 = new Car("car2", 1);
        parkingLot.takePlace(car2);
        Transport car3 = new Car("car3", 1);
        assertThat(parkingLot.freePlace(truck2)).isTrue();
        assertThat(parkingLot.freePlace(truck4)).isTrue();
        assertThat(parkingLot.freePlace(car2)).isTrue();
        assertThat(parkingLot.freePlace(car3)).isFalse();
        assertThat(parkingLot.getTruckCapacity()[0]).isEqualTo(1);
        assertThat(parkingLot.getTruckCapacity()[1]).isEqualTo(1);
        assertThat(parkingLot.getTruckCapacity()[2]).isEqualTo(1);
        assertThat(parkingLot.getTruckCapacity()[3]).isEqualTo(0);
        assertThat(parkingLot.getTruckCapacity()[4]).isEqualTo(0);
        assertThat(parkingLot.getTruckCapacity()[5]).isEqualTo(0);
        assertThat(parkingLot.getTruckCapacity()[6]).isEqualTo(1);
        assertThat(parkingLot.getTruckCapacity()[7]).isEqualTo(1);
        assertThat(parkingLot.getTruckCapacity()[8]).isEqualTo(1);
        assertThat(parkingLot.getCarCapacity()[0]).isEqualTo(1);
        assertThat(parkingLot.getCarCapacity()[1]).isEqualTo(0);
        assertThat(parkingLot.getCarCapacity()[2]).isEqualTo(0.5);
        assertThat(parkingLot.getCarCapacity()[3]).isEqualTo(1);
        assertThat(parkingLot.getCarCapacity()[4]).isEqualTo(0);
    }
}