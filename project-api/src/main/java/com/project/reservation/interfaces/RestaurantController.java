package com.project.reservation.interfaces;

import com.project.reservation.domain.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = new ArrayList<>();

        Restaurant restaurant = null;

        restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));

        return restaurants;
    }
}
