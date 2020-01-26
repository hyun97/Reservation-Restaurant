package com.project.reservation.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    List<Restaurant> findAll();

    List<Restaurant> findAllByAddressContainingAndCategoryId(String region, Long categoryId);

    Optional<Restaurant> findById(Long id);

    @SuppressWarnings("unchecked")
    Restaurant save(Restaurant restaurant);
}
