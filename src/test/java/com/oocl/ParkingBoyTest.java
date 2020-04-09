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

    @Test
    public void should_return_car_given_parking_ticket() {
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingTicket parkingTicket = new ParkingTicket();

        Car car = parkingBoy.fetchCar(parkingTicket);
        Assert.assertNotNull(car);
    }

    @Test
    public void should_return_car_given_correct_ticket() {
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();

        ParkingTicket parkingTicket = parkingBoy.park(car);
        Assert.assertEquals(car, parkingBoy.fetchCar(parkingTicket));
    }

    @Test
    public void should_not_return_car_given_incorrect_ticket() {
        ParkingBoy parkingBoy = new ParkingBoy();
        Car carOne = new Car();
        ParkingTicket parkingTicket = new ParkingTicket();

        ParkingTicket parkingTicketForCarOne = parkingBoy.park(carOne);
        parkingBoy.fetchCar(parkingTicket);

        Assert.assertNotEquals(carOne, parkingBoy.fetchCar(parkingTicket));
    }
}
