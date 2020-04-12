package com.oocl;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private static final int MAX_CAPACITY = 10;
    private Map<ParkingTicket, Car> ticketCarMap = new HashMap<ParkingTicket, Car>();
    private int occupied;

    public boolean isNotFull() {
        return occupied < MAX_CAPACITY;
    }

    public boolean hasTicket(ParkingTicket ticket) {
        return ticketCarMap.containsKey(ticket);
    }

    public ParkingLot(int occupied) {
        this.occupied = occupied;
    }

    public ParkingLot() {
        this.occupied = ticketCarMap.size();
    }

    public ParkingTicket park(Car car) throws NoParkingSpaceException {
        if (isNotFull()) {
            ParkingTicket parkingTicket = new ParkingTicket();
            ticketCarMap.put(parkingTicket, car);
            occupied++;
            return parkingTicket;
        } else {
            throw new NoParkingSpaceException("Not enough position.");
        }
    }

    public Car fetchCar(ParkingTicket parkingTicket) throws UnrecognizedParkingTicketException {
        Car car = ticketCarMap.remove(parkingTicket);
        if (car == null) {
            throw new UnrecognizedParkingTicketException("Unrecognized Parking Ticket");
        }
        return car;
    }
}
