package com.stackroute.trackservice.exceptions;

public class TrackAlreadyExistException extends  Exception{
    private  String message;

    public TrackAlreadyExistException() {
    }

    public TrackAlreadyExistException(String message) {
        super();
        this.message = message;
    }
}
