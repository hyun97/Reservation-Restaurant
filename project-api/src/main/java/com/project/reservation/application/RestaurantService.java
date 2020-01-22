package com.project.reservation.application;

import com.project.reservation.domain.MenuItem;
import com.project.reservation.domain.MenuItemRepository;
import com.project.reservation.domain.Restaurant;
import com.project.reservation.domain.RestaurantNotFoundException;
import com.project.reservation.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    MenuItemRepository menuItemRepository;

//    public RestaurantService(RestaurantRepository restaurantRepository, MenuItemRepository menuItemRepository) {
//        this.restaurantRepository = restaurantRepository;
//        this.menuItemRepository = menuItemRepository;
//    }

    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();

        return restaurants;
    }

    public Restaurant getRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));

        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItems);

        return restaurant;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        Restaurant saved = restaurantRepository.save(restaurant);

        return saved;
    }

    @Transactional // DB에 변경값 저장
    public void updateRestaurant(long id, String name, String address) {
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);

        restaurant.updateInformation(name, address);
    }
}
