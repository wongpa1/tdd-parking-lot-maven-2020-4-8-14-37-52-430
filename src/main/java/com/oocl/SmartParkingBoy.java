package com.oocl;

import java.util.Comparator;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        Comparator<ParkingLot> comparator = Comparator.comparing(ParkingLot::spaceLeft);
        ParkingLot selectedParkingLot = this.getParkingLots().stream().max(comparator).get();
        return selectedParkingLot.park(car);
    }
}
