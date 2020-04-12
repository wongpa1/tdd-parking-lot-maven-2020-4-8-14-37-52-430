package com.oocl;

public class ParkingBoy {

    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        return this.parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (parkingTicket == null) {
            throw new NoParkingTicketException("Please provide your parking ticket.");
        }
        return this.parkingLot.fetchCar(parkingTicket);
    }
}
