package com.oocl;

import exception.NoParkingSpaceException;
import exception.NoParkingTicketException;
import exception.UnrecognizedParkingTicketException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ParkingBoy {

    private List<ParkingLot> parkingLots = new ArrayList<>();

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public ParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots.addAll(Arrays.asList(parkingLots));
    }

    public ParkingTicket park(Car car) throws NoParkingSpaceException {
        Optional<ParkingLot> selectedParkingLot = this.parkingLots.stream().filter(ParkingLot::isNotFull).findFirst();
        if (selectedParkingLot.isPresent()) {
            return selectedParkingLot.get().park(car);
        } else {
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