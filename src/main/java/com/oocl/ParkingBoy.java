package com.oocl;

import java.util.HashMap;
import java.util.Map;


public class ParkingBoy {

    private Map<ParkingTicket, Car> ticketCarMap = new HashMap<ParkingTicket, Car>();

    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        ticketCarMap.put(parkingTicket,car);
        return parkingTicket;
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        Car car = ticketCarMap.get(parkingTicket);
        return car;
    }
}
