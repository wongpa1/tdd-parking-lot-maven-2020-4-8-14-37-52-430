package com.oocl;

import exception.NoParkingSpaceException;
import exception.NoParkingTicketException;
import exception.UnrecognizedParkingTicketException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SuperSmartParkingBoyTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_park_car_to_parkingLot_by_super_smart_parkingBoy_when_parkingLot_has_higher_position_rate() {

        ParkingLot parkingLotOne = new ParkingLot();
        ParkingLot parkingLotTwo = new ParkingLot();
        SuperSmartParkingBoy supersmartparkingBoy = new SuperSmartParkingBoy(parkingLotOne, parkingLotTwo);
        Car carOne = new Car();
        Car carTwo = new Car();

        parkingLotOne.park(carOne);
        ParkingTicket parkingTicketForCarTwo = supersmartparkingBoy.park(carTwo);
        Car FetchedCarFromParkingLotTwo = parkingLotTwo.fetchCar(parkingTicketForCarTwo);

        Assert.assertEquals(carTwo, FetchedCarFromParkingLotTwo);
    }

    @Test
    public void should_fetch_car_by_super_smart_parkingBoy() {

        ParkingLot parkingLotOne = new ParkingLot();
        ParkingLot parkingLotTwo = new ParkingLot();
        SuperSmartParkingBoy supersmartparkingBoy = new SuperSmartParkingBoy(parkingLotOne, parkingLotTwo);
        Car carOne = new Car();

        ParkingTicket parkingTicketForCarOne = supersmartparkingBoy.park(carOne);
        Car FetchedCarFromSmartParkingBoy = supersmartparkingBoy.fetch(parkingTicketForCarOne);

        Assert.assertEquals(carOne, FetchedCarFromSmartParkingBoy);

    }

    @Test
    public void should_park_car_to_parkingLot_by_super_smart_parkingBoy() {
        ParkingLot parkingLot = new ParkingLot();
        SuperSmartParkingBoy supersmartparkingBoy = new SuperSmartParkingBoy(parkingLot);
        Car carOne = new Car();

        ParkingTicket parkingTicketFromParkingBoy = supersmartparkingBoy.park(carOne);
        Car FetchedCarOneFromParkingLot = parkingLot.fetchCar(parkingTicketFromParkingBoy);

        Assert.assertEquals(carOne, FetchedCarOneFromParkingLot);
    }

    @Test
    public void should_fetch_car_from_parkingLot_by_super_smart_parkingBoy() {
        ParkingLot parkingLot = new ParkingLot();
        SuperSmartParkingBoy supersmartparkingBoy = new SuperSmartParkingBoy(parkingLot);
        Car carOne = new Car();

        ParkingTicket parkingTicket = parkingLot.park(carOne);
        Car carFetchFromParkingBoy = supersmartparkingBoy.fetch(parkingTicket);

        Assert.assertEquals(carOne, carFetchFromParkingBoy);
    }

    @Test
    public void should_return_exception_when_fetch_with_wrong_ticket() {
        expectedException.expect(UnrecognizedParkingTicketException.class);
        expectedException.expectMessage("Unrecognized Parking Ticket");

        ParkingLot parkingLot = new ParkingLot();
        SuperSmartParkingBoy supersmartparkingBoy = new SuperSmartParkingBoy(parkingLot);
        Car carOne = new Car();

        ParkingTicket parkingTicketForCarOne = supersmartparkingBoy.park(carOne);
        supersmartparkingBoy.fetch(new ParkingTicket());
    }

    @Test
    public void should_return_exception_when_fetch_without_ticket() {
        expectedException.expect(NoParkingTicketException.class);
        expectedException.expectMessage("Please provide your parking ticket.");

        ParkingLot parkingLot = new ParkingLot();
        SuperSmartParkingBoy supersmartparkingBoy = new SuperSmartParkingBoy(parkingLot);

        supersmartparkingBoy.fetch(null);
    }

    @Test
    public void should_return_exception_when_parking_full_parking_lot() {
        expectedException.expect(NoParkingSpaceException.class);
        expectedException.expectMessage("Not enough position.");

        ParkingLot parkingLot = new ParkingLot(0);
        SuperSmartParkingBoy supersmartparkingBoy = new SuperSmartParkingBoy(parkingLot);
        Car carOne = new Car();

        supersmartparkingBoy.park(carOne);
    }
}
