package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class ParkingBoyTest {
    @Test
    public void should_return_parking_ticket_given_car() {
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();

        ParkingTicket parkingTicket = parkingBoy.park(car);
        Assert.assertNotNull(parkingTicket);
    }
}
