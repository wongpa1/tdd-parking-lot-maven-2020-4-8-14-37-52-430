package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class SmartParkingBoyTest {

    @Test
    public void should_park_car_to_parkingLot_by_smart_parkingBoy_when_parkingLot_has_space() {

        ParkingLot parkingLotOne = new ParkingLot(5, 10);
        ParkingLot parkingLotTwo = new ParkingLot(7, 10);
        SmartParkingBoy smartparkingBoy = new SmartParkingBoy(parkingLotOne, parkingLotTwo);
        Car carOne = new Car();

        ParkingTicket parkingTicketForCarOne = smartparkingBoy.park(carOne);
        Car FetchedCarFromParkingLotOne = parkingLotOne.fetchCar(parkingTicketForCarOne);

        Assert.assertEquals(carOne, FetchedCarFromParkingLotOne);
    }

    @Test
    public void should_fetch_car_by_smart_parkingBoy() {

        ParkingLot parkingLotOne = new ParkingLot(5, 10);
        ParkingLot parkingLotTwo = new ParkingLot(7, 10);
        SmartParkingBoy smartparkingBoy = new SmartParkingBoy(parkingLotOne, parkingLotTwo);
        Car carOne = new Car();

        ParkingTicket parkingTicketForCarOne = smartparkingBoy.park(carOne);
        Car FetchedCarFromSmartParkingBoy = smartparkingBoy.fetch(parkingTicketForCarOne);

        Assert.assertEquals(carOne, FetchedCarFromSmartParkingBoy);

    }
}
