package com.oocl;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private static final int MAX_CAPACITY = 10;
    private Map<ParkingTicket, Car> ticketCarMap = new HashMap<ParkingTicket, Car>();
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
        this.capacity = 0;
    }

    public ParkingTicket park(Car car) {
        if (capacity < MAX_CAPACITY) {
            ParkingTicket parkingTicket = new ParkingTicket();
            ticketCarMap.put(parkingTicket, car);
            capacity++;
            return parkingTicket;
        }
        return null;
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        return ticketCarMap.remove(parkingTicket);
    }
}
