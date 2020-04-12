package com.oocl;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ParkingBoyTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_park_car_to_parkingLot_by_parkingBoy() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car carOne = new Car();

        ParkingTicket parkingTicketFromParkingBoy = parkingBoy.park(carOne);
        Car FetchedCarOneFromParkingLot = parkingLot.fetchCar(parkingTicketFromParkingBoy);

        Assert.assertEquals(carOne, FetchedCarOneFromParkingLot);
    }

    @Test
    public void should_fetch_car_from_parkingLot_by_parkingBoy() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car carOne = new Car();

        ParkingTicket parkingTicket = parkingLot.park(carOne);
        Car carFetchFromParkingBoy = parkingBoy.fetch(parkingTicket);

        Assert.assertEquals(carOne, carFetchFromParkingBoy);
    }

    @Test
    public void should_return_exception_when_fetch_with_wrong_ticket() {
        expectedException.expect(UnrecognizedParkingTicketException.class);
        expectedException.expectMessage("Unrecognized Parking Ticket");

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car carOne = new Car();

        ParkingTicket parkingTicketForCarOne = parkingBoy.park(carOne);
        parkingBoy.fetch(new ParkingTicket());
    }

    @Test
    public void should_return_exception_when_fetch_without_ticket() {
        expectedException.expect(NoParkingTicketException.class);
        expectedException.expectMessage("Please provide your parking ticket.");

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        parkingBoy.fetch(null);
    }

    @Test
    public void should_return_exception_when_parking_full_parking_lot() {
        expectedException.expect(NoParkingSpaceException.class);
        expectedException.expectMessage("Not enough position.");

        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car carOne = new Car();

        parkingBoy.park(carOne);
    }

    @Test
    public void should_parking_car_to_parkingLotTwo_by_parkingBoy_when_parkingLotOne_is_full() {

        ParkingLot parkingLotOne = new ParkingLot(10);
        ParkingLot parkingLotTwo = new ParkingLot(5);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotOne, parkingLotTwo);
        Car carOne = new Car();

        parkingBoy.park(carOne);
        ParkingTicket parkingTicketForCarOne = parkingBoy.park(carOne);
        Car FetchedCarOneFromParkingLotTwo = parkingLotTwo.fetchCar(parkingTicketForCarOne);

        Assert.assertEquals(carOne, FetchedCarOneFromParkingLotTwo);
    }
}
