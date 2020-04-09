package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class ParkingBoyTest {
    @Test
    public void should_park_car_to_parkingLot_by_parkingBoy() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car carOne = new Car();

        ParkingTicket parkingTicketFromParkingBoy = parkingBoy.park(carOne);
        Car FetchedCarOneFromParkingLot = parkingLot.fetchCar(parkingTicketFromParkingBoy);

        Assert.assertEquals(carOne,FetchedCarOneFromParkingLot);
    }
}
