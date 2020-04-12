package com.oocl;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private static final int MAX_CAPACITY = 10;
    private Map<ParkingTicket, Car> ticketCarMap = new HashMap<ParkingTicket, Car>();
    private int capacity;

    private boolean isNotFull(){
        return capacity < MAX_CAPACITY;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
        this.capacity = 0;
    }

    public ParkingTicket park(Car car) {
        if (isNotFull()) {
            ParkingTicket parkingTicket = new ParkingTicket();
            ticketCarMap.put(parkingTicket, car);
            capacity++;
            return parkingTicket;
        }
        return null;
    }

    public Car fetchCar(ParkingTicket parkingTicket) throws UnrecognizedParkingTicketException {
        Car car = ticketCarMap.remove(parkingTicket);
        if(car == null){
            throw new UnrecognizedParkingTicketException("Unrecognized Parking Ticket");
        }
        return ticketCarMap.remove(parkingTicket);
    }
}
