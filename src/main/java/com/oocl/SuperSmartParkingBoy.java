package com.oocl;

import java.util.Comparator;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        Comparator<ParkingLot> comparator = Comparator.comparing(ParkingLot::positionRate);
        //TODO: Check isPresent
        ParkingLot selectedParkingLot = this.getParkingLots().stream().max(comparator).get();
        return selectedParkingLot.park(car);
    }
}
