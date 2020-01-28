package com.project.reservation.application;

public class PasswordWrongException extends RuntimeException {

    public PasswordWrongException() {
        super("Password is wrong");
    }
}

