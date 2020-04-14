package com.oocl;

import java.util.Comparator;
import java.util.Optional;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        Comparator<ParkingLot> comparator = Comparator.comparing(ParkingLot::positionRate);
        Optional<ParkingLot> selectedParkingLot = this.getParkingLots().stream().max(comparator);
        if (selectedParkingLot.isPresent()) {
            return selectedParkingLot.get().park(car);
        } else {
            throw new NoParkingSpaceException("Not enough position.");
        }
    }
}
