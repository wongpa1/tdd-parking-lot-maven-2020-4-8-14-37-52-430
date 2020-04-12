package com.oocl;

public class NoParkingTicketException extends RuntimeException {
    public NoParkingTicketException(String message) {
        super(message);
    }
}
