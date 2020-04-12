package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class SmartParkingBoyTest {
    @Test
    public void should_park_car_to_parkingLot_by_smart_parkingBoy_when_parkingLot_has_space() {

        ParkingLot parkingLotOne = new ParkingLot(3, 10);
        ParkingLot parkingLotTwo = new ParkingLot(5, 10);
        SmartParkingBoy smartparkingBoy = new SmartParkingBoy(parkingLotOne, parkingLotTwo);
        Car carOne = new Car();

        ParkingTicket parkingTicketForCarOne = smartparkingBoy.park(carOne);
        Car FetchedCarOneFromParkingLotOne = parkingLotOne.fetchCar(parkingTicketForCarOne);

        Assert.assertEquals(carOne, FetchedCarOneFromParkingLotOne);
    }
}
