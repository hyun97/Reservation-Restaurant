package com.project.reservation.domain;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    @SuppressWarnings("unchecked")
    Review save(Review review);
}
