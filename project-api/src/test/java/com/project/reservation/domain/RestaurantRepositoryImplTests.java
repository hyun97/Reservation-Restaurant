package com.project.reservation.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RestaurantRepositoryImplTests {

    @Test
    public void save() {
        RestaurantRepository repository = new RestaurantRepositoryImpl();

        int oldCount = repository.findAll().size();

        Restaurant restaurant = new Restaurant("BeRyong", "Seoul");
        repository.save(restaurant);

        assertThat(restaurant.getId()).isEqualTo(1234L);

        int newCount = repository.findAll().size();

        assertThat(newCount - oldCount).isEqualTo(1);
    }

}