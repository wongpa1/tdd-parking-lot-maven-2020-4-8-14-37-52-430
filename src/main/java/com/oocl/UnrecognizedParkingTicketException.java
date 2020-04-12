package com.oocl;

public class UnrecognizedParkingTicketException extends RuntimeException{
    public UnrecognizedParkingTicketException(String unrecognized_parking_ticket) {
        super(unrecognized_parking_ticket);
    }
}
