package com.oocl;

public class NoParkingSpaceException extends RuntimeException {
    public NoParkingSpaceException(String message) {
        super(message);
    }
}
