package com.project.reservation.application;

import com.project.reservation.domain.Restaurant;
import com.project.reservation.domain.RestaurantNotFoundException;
import com.project.reservation.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    // 모든 레스토랑 리스트
    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    // 해당 id 레스토랑 정보 반환
    public Restaurant getRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));

        return restaurant;
    }

    // 레스토랑 추가
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    // 레스토랑 수정
    @Transactional // DB에 변경값 저장
    public void updateRestaurant(long id, String name, String address, Long categoryId) {
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);

        restaurant.updateInformation(name, address, categoryId);
    }
}
