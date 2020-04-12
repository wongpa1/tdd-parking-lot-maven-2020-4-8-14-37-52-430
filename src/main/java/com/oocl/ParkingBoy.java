package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingBoy {

    private List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();

    public ParkingBoy(ParkingLot... parkingLots) {
        this.parkingLotList.addAll(Arrays.asList(parkingLots));
    }

    public ParkingTicket park(Car car) {
        ParkingLot selectedParkingLot = this.parkingLotList.stream().filter(parkingLot -> parkingLot.isNotFull()).findFirst().get();
        return selectedParkingLot.park(car);
    }

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