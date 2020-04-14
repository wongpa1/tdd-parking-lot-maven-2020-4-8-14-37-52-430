package com.oocl;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SmartParkingBoyTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

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

    @Test
    public void should_park_car_to_parkingLot_by_smart_parkingBoy() {
        ParkingLot parkingLot = new ParkingLot();
        SmartParkingBoy smartparkingBoy = new SmartParkingBoy(parkingLot);
        Car carOne = new Car();

        ParkingTicket parkingTicketFromParkingBoy = smartparkingBoy.park(carOne);
        Car FetchedCarOneFromParkingLot = parkingLot.fetchCar(parkingTicketFromParkingBoy);

        Assert.assertEquals(carOne, FetchedCarOneFromParkingLot);
    }

    @Test
    public void should_fetch_car_from_parkingLot_by_smart_parkingBoy() {
        ParkingLot parkingLot = new ParkingLot();
        SmartParkingBoy smartparkingBoy = new SmartParkingBoy(parkingLot);
        Car carOne = new Car();

        ParkingTicket parkingTicket = parkingLot.park(carOne);
        Car carFetchFromParkingBoy = smartparkingBoy.fetch(parkingTicket);

        Assert.assertEquals(carOne, carFetchFromParkingBoy);
    }

    @Test
    public void should_return_exception_when_fetch_with_wrong_ticket() {
        expectedException.expect(UnrecognizedParkingTicketException.class);
        expectedException.expectMessage("Unrecognized Parking Ticket");

        ParkingLot parkingLot = new ParkingLot();
        SmartParkingBoy smartparkingBoy = new SmartParkingBoy(parkingLot);
        Car carOne = new Car();

        ParkingTicket parkingTicketForCarOne = smartparkingBoy.park(carOne);
        smartparkingBoy.fetch(new ParkingTicket());
    }

    @Test
    public void should_return_exception_when_fetch_without_ticket() {
        expectedException.expect(NoParkingTicketException.class);
        expectedException.expectMessage("Please provide your parking ticket.");

        ParkingLot parkingLot = new ParkingLot();
        SmartParkingBoy smartparkingBoy = new SmartParkingBoy(parkingLot);

        smartparkingBoy.fetch(null);
    }

    @Test
    public void should_return_exception_when_parking_full_parking_lot() {
        expectedException.expect(NoParkingSpaceException.class);
        expectedException.expectMessage("Not enough position.");

        ParkingLot parkingLot = new ParkingLot(10);
        SmartParkingBoy smartparkingBoy = new SmartParkingBoy(parkingLot);
        Car carOne = new Car();

        smartparkingBoy.park(carOne);
    }

    @Test
    public void should_park_car_to_parkingLotTwo_by_smart_parkingBoy_when_parkingLotOne_is_full() {

        ParkingLot parkingLotOne = new ParkingLot(10);
        ParkingLot parkingLotTwo = new ParkingLot(5);
        SmartParkingBoy smartparkingBoy = new SmartParkingBoy(parkingLotOne, parkingLotTwo);
        Car carOne = new Car();

        ParkingTicket parkingTicketForCarOne = smartparkingBoy.park(carOne);
        Car FetchedCarOneFromParkingLotTwo = parkingLotTwo.fetchCar(parkingTicketForCarOne);

        Assert.assertEquals(carOne, FetchedCarOneFromParkingLotTwo);
    }
}
