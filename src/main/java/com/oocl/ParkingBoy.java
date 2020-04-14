package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingBoy {

    private List<ParkingLot> parkingLots = new ArrayList<>();

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public ParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots.addAll(Arrays.asList(parkingLots));
    }

    public ParkingTicket park(Car car) throws NoParkingSpaceException {
        //TODO: Check isPresent
        if(this.parkingLots.stream().anyMatch(ParkingLot::isNotFull)) {
            ParkingLot selectedParkingLot = this.parkingLots.stream().filter(ParkingLot::isNotFull).findFirst().get();
            return selectedParkingLot.park(car);
        }
        else{
            throw new NoParkingSpaceException("Not enough position.");
        }
    }

    public Car fetch(ParkingTicket parkingTicket) throws NoParkingTicketException, UnrecognizedParkingTicketException {
        if (parkingTicket == null) {
            throw new NoParkingTicketException("Please provide your parking ticket.");
        }
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasTicket(parkingTicket)) {
                return parkingLot.fetchCar(parkingTicket);
            }
        }
        throw new UnrecognizedParkingTicketException("Unrecognized Parking Ticket");
    }
}