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
        assertThat(parkingLot.getCarCapacity()[3]).isEqualTo(1);
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
        parkingLot.getCarCapacity()[3] = 0.5;
        assertThat(parkingLot.takePlace(car)).isFalse();
    }

    @Test
    void takePlaceWhenCarParkingIsBuzyVer4() {
        ParkingLot parkingLot = new ParkingLot(7, 9);
        Transport car = new Car("car", 1);
        Arrays.fill(parkingLot.getCarCapacity(), 1);
        parkingLot.getCarCapacity()[2] = 0.000000000000001;
        parkingLot.getCarCapacity()[5] = 0.000000000000001;
        assertThat(parkingLot.takePlace(car)).isFalse();
    }

    @Test
    void freePlaceVer1() {
        ParkingLot parkingLot = new ParkingLot(2, 9);
        Transport car1 = new Car("car1", 1);
        parkingLot.getCarCapacity()[0] = 1;
        car1.setSpotsRecords(0, 1.0);
        car1.setCarsRecords(car1.getName());
        CarsRecords.setCarsRecords(car1.getName(), CarsRecords.TypeParking.CAR_PARKING);

        Transport car2 = new Car("car2", 1);
        parkingLot.getCarCapacity()[1] = 1;
        car2.setSpotsRecords(1, 1.0);
        car2.setCarsRecords(car2.getName());
        CarsRecords.setCarsRecords(car2.getName(), CarsRecords.TypeParking.CAR_PARKING);

        assertThat(parkingLot.freePlace(car1)).isTrue();
        assertThat(parkingLot.getCarCapacity()[0]).isEqualTo(0);
        assertThat(parkingLot.getCarCapacity()[1]).isEqualTo(1);
    }

    @Test
    void freePlaceVer2() {
        ParkingLot parkingLot = new ParkingLot(2, 9);
        Transport car1 = new Car("car1", 1);
        parkingLot.getCarCapacity()[0] = 1;
        car1.setSpotsRecords(0, 1.0);
        car1.setCarsRecords(car1.getName());
        CarsRecords.setCarsRecords(car1.getName(), CarsRecords.TypeParking.CAR_PARKING);

        Transport car2 = new Car("car2", 1);
        parkingLot.getCarCapacity()[1] = 1;
        car2.setSpotsRecords(1, 1.0);
        car2.setCarsRecords(car2.getName());
        CarsRecords.setCarsRecords(car2.getName(), CarsRecords.TypeParking.CAR_PARKING);
        assertThat(parkingLot.freePlace(car2)).isTrue();
        assertThat(parkingLot.getCarCapacity()[0]).isEqualTo(1);
        assertThat(parkingLot.getCarCapacity()[1]).isEqualTo(0);
    }

    @Test
    void freePlaceVer3() {
        ParkingLot parkingLot = new ParkingLot(5, 9);
        Transport truck1 = new Truck("truck1", 3);
        parkingLot.getTruckCapacity()[0] = 1;
        parkingLot.getTruckCapacity()[1] = 1;
        parkingLot.getTruckCapacity()[2] = 1;
        truck1.setSpotsRecords(0, 1.0);
        truck1.setSpotsRecords(1, 1.0);
        truck1.setSpotsRecords(2, 1.0);
        truck1.setCarsRecords(truck1.getName());
        CarsRecords.setCarsRecords(truck1.getName(), CarsRecords.TypeParking.TRUCK_PARKING);

        Transport truck2 = new Truck("truck2", 3);
        parkingLot.getTruckCapacity()[3] = 1;
        parkingLot.getTruckCapacity()[4] = 1;
        parkingLot.getTruckCapacity()[5] = 1;
        truck2.setSpotsRecords(3, 1.0);
        truck2.setSpotsRecords(4, 1.0);
        truck2.setSpotsRecords(5, 1.0);
        truck2.setCarsRecords(truck2.getName());
        CarsRecords.setCarsRecords(truck2.getName(), CarsRecords.TypeParking.TRUCK_PARKING);

        Transport truck3 = new Truck("truck3", 3);
        parkingLot.getTruckCapacity()[6] = 1;
        parkingLot.getTruckCapacity()[7] = 1;
        parkingLot.getTruckCapacity()[8] = 1;
        truck3.setSpotsRecords(6, 1.0);
        truck3.setSpotsRecords(7, 1.0);
        truck3.setSpotsRecords(8, 1.0);
        truck3.setCarsRecords(truck3.getName());
        CarsRecords.setCarsRecords(truck3.getName(), CarsRecords.TypeParking.TRUCK_PARKING);

        Transport car1 = new Car("car1", 1);
        parkingLot.getCarCapacity()[0] = 1;
        car1.setSpotsRecords(0, 1.0);
        car1.setCarsRecords(car1.getName());
        CarsRecords.setCarsRecords(car1.getName(), CarsRecords.TypeParking.CAR_PARKING);

        Transport truck4 = new Truck("truck4", 1.5);
        parkingLot.getCarCapacity()[1] = 1;
        parkingLot.getCarCapacity()[2] = 0.5;
        truck4.setSpotsRecords(1, 1.0);
        truck4.setSpotsRecords(2, 0.5);
        truck4.setCarsRecords(truck4.getName());
        CarsRecords.setCarsRecords(truck4.getName(), CarsRecords.TypeParking.CAR_PARKING);

        Transport truck5 = new Truck("truck5", 1.5);
        parkingLot.getCarCapacity()[2] = 1;
        parkingLot.getCarCapacity()[3] = 1;
        truck5.setSpotsRecords(2, 0.5);
        truck5.setSpotsRecords(3, 1.0);
        truck5.setCarsRecords(truck5.getName());
        CarsRecords.setCarsRecords(truck5.getName(), CarsRecords.TypeParking.CAR_PARKING);

        Transport car2 = new Car("car2", 1);
        parkingLot.getCarCapacity()[4] = 1;
        car2.setSpotsRecords(4, 1.0);
        car2.setCarsRecords(car2.getName());
        CarsRecords.setCarsRecords(car2.getName(), CarsRecords.TypeParking.CAR_PARKING);

        Transport car3 = new Car("car3", 1);
        assertThat(parkingLot.freePlace(car3)).isFalse();
        assertThat(parkingLot.freePlace(truck2)).isTrue();
        assertThat(parkingLot.freePlace(truck4)).isTrue();
        assertThat(parkingLot.freePlace(car2)).isTrue();

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