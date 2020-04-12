package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class SuperSmartParkingBoyTest {

    @Test
    public void should_park_car_to_parkingLot_by_smart_parkingBoy_when_parkingLot_has_higher_position_rate() {

        ParkingLot parkingLotOne = new ParkingLot(5, 10);
        ParkingLot parkingLotTwo = new ParkingLot(7, 10);
        SuperSmartParkingBoy supersmartparkingBoy = new SuperSmartParkingBoy(parkingLotOne, parkingLotTwo);
        Car carOne = new Car();

        ParkingTicket parkingTicketForCarOne = supersmartparkingBoy.park(carOne);
        Car FetchedCarFromParkingLotOne = parkingLotOne.fetchCar(parkingTicketForCarOne);

        Assert.assertEquals(carOne, FetchedCarFromParkingLotOne);
    }
}
