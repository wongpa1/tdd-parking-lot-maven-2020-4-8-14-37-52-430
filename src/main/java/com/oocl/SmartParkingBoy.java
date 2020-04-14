package com.oocl;

import java.util.Comparator;
import java.util.Optional;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        Comparator<ParkingLot> comparator = Comparator.comparing(ParkingLot::spaceLeft);
        Optional<ParkingLot> selectedParkingLot = this.getParkingLots().stream().max(comparator);
        if (selectedParkingLot.isPresent()) {
            return selectedParkingLot.get().park(car);
        } else {
            throw new NoParkingSpaceException("Not enough position.");
        }
    }
}
