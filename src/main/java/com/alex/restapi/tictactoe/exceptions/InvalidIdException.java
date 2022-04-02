package com.alex.restapi.tictactoe.exceptions;

public class InvalidIdException extends RuntimeException{

    public InvalidIdException(String message) {
        super(message);
    }
}
