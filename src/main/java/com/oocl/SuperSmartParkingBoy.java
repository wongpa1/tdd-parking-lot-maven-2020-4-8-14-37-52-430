package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {

    private List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();

    public SuperSmartParkingBoy(ParkingLot... parkingLots) {
        this.parkingLotList.addAll(Arrays.asList(parkingLots));
    }

    @Override
    public ParkingTicket park(Car car) {
        Comparator<ParkingLot> comparator = Comparator.comparing(ParkingLot::positionRate);
        ParkingLot selectedParkingLot = this.parkingLotList.stream().max(comparator).get();
        return selectedParkingLot.park(car);
    }

    @Override
    public Car fetch(ParkingTicket parkingTicket) throws NoParkingTicketException, UnrecognizedParkingTicketException {
        if (parkingTicket == null) {
            throw new NoParkingTicketException("Please provide your parking ticket.");
        }
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.hasTicket(parkingTicket)) {
                return parkingLot.fetchCar(parkingTicket);
            }
        }
        throw new UnrecognizedParkingTicketException("Unrecognized Parking Ticket");
    }
}
