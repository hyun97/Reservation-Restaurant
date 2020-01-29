package com.project.reservation.interfaces;

import com.project.reservation.application.ReservationService;
import com.project.reservation.domain.Reservation;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public List<Reservation> list(Authentication authentication) {
        Claims claims = (Claims) authentication.getPrincipal();

        Long restaurantId = claims.get("restaurantId", Long.class);

        List<Reservation> reservations = reservationService.getReservations(restaurantId);

        return reservations;
    }

}
