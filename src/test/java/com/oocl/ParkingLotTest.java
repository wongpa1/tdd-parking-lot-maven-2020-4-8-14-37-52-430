package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {

    @Test
    public void should_return_parking_ticket_given_car() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        ParkingTicket parkingTicket = parkingLot.park(car);
        Assert.assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_car_given_correct_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        ParkingTicket parkingTicket = parkingLot.park(car);
        Assert.assertEquals(car, parkingLot.fetchCar(parkingTicket));
    }

    @Test
    public void should_not_return_car_given_incorrect_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Car carOne = new Car();
        ParkingTicket parkingTicket = new ParkingTicket();

        parkingLot.park(carOne);
        Assert.assertNotEquals(carOne, parkingLot.fetchCar(parkingTicket));
    }

    @Test
    public void should_not_return_car_given_used_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Car carOne = new Car();

        ParkingTicket parkingTicketForCarOne = parkingLot.park(carOne);
        parkingLot.fetchCar(parkingTicketForCarOne);

        Assert.assertNull(parkingLot.fetchCar(parkingTicketForCarOne));
    }

    @Test
    public void should_not_return_ticket_given_ParkingLot_is_full() {
        ParkingLot parkingLot = new ParkingLot(9);
        Car carOne = new Car();
        Car carTwo = new Car();

        parkingLot.park(carOne);
        Assert.assertNull(parkingLot.park(carTwo));
    }
}
