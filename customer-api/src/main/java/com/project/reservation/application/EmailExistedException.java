package com.project.reservation.application;

public class EmailExistedException extends RuntimeException {

    EmailExistedException(String email) {
        super("Email is already registered: " + email);
    }

}
