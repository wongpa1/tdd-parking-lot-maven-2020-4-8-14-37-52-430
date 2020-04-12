package com.oocl;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    public static final int DEFAULT_MAX_CAPACITY = 10;
    private Map<ParkingTicket, Car> ticketCarMap = new HashMap<ParkingTicket, Car>();
    private int maxCapacity;
    private int occupied;

    public boolean isNotFull() {
        return occupied < maxCapacity;
    }

    public boolean hasTicket(ParkingTicket ticket) {
        return ticketCarMap.containsKey(ticket);
    }

    public int spaceLeft() {
        return maxCapacity - occupied;
    }

    public ParkingLot(int occupied) {
        this.occupied = occupied;
        this.maxCapacity = DEFAULT_MAX_CAPACITY;
    }

    public ParkingLot(int occupied, int maxCapacity) {
        this.occupied = occupied;
        this.maxCapacity = maxCapacity;
    }

    public ParkingLot() {
        this.occupied = ticketCarMap.size();
        this.maxCapacity = 10;
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
