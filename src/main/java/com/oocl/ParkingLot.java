package com.oocl;

import exception.NoParkingSpaceException;
import exception.UnrecognizedParkingTicketException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    public static final int DEFAULT_MAX_CAPACITY = 10;
    private Map<ParkingTicket, Car> ticketCarMap = new HashMap<>();
    private int maxCapacity;

    public boolean isNotFull() {
        return ticketCarMap.size() < maxCapacity;
    }

    public boolean hasTicket(ParkingTicket ticket) {
        return ticketCarMap.containsKey(ticket);
    }

    public int spaceLeft() {
        return maxCapacity - ticketCarMap.size();
    }

    public double positionRate() {
        return (double) spaceLeft() / maxCapacity;
    }

    public ParkingLot(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public ParkingLot() {
        this.maxCapacity = DEFAULT_MAX_CAPACITY;
    }

    public ParkingTicket park(Car car) throws NoParkingSpaceException {
        if (isNotFull()) {
            ParkingTicket parkingTicket = new ParkingTicket();
            ticketCarMap.put(parkingTicket, car);
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
