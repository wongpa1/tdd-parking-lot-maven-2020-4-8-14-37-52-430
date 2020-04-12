package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    private List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();

    public SmartParkingBoy(ParkingLot... parkingLots) {
        this.parkingLotList.addAll(Arrays.asList(parkingLots));
    }

    @Override
    public ParkingTicket park(Car car) {
        Comparator<ParkingLot> comparator = Comparator.comparing( ParkingLot::spaceLeft );
        ParkingLot selectedParkingLot = this.parkingLotList.stream().max(comparator).get();
        return selectedParkingLot.park(car);
    }
}
