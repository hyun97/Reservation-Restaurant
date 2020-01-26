package com.project.reservation.application;

import com.project.reservation.domain.MenuItem;
import com.project.reservation.domain.MenuItemRepository;
import com.project.reservation.domain.Restaurant;
import com.project.reservation.domain.RestaurantNotFoundException;
import com.project.reservation.domain.RestaurantRepository;
import com.project.reservation.domain.Review;
import com.project.reservation.domain.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;
    private MenuItemRepository menuItemRepository;
    private ReviewRepository reviewRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, MenuItemRepository menuItemRepository,
                             ReviewRepository reviewRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuItemRepository = menuItemRepository;
        this.reviewRepository = reviewRepository;
    }

    // 모든 레스토랑 리스트
    public List<Restaurant> getRestaurants(String region, long categoryId) {
        return restaurantRepository
                .findAllByAddressContainingAndCategoryId(region, categoryId);
    }

    // 해당 id 레스토랑 정보 반환
    public Restaurant getRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));

        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItems);

        List<Review> review = reviewRepository.findAllByRestaurantId(id);
        restaurant.setReviews(review);

        return restaurant;
    }

    // 레스토랑 추가
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    // 레스토랑 수정
    @Transactional // DB에 변경값 저장
    public void updateRestaurant(long id, String name, String address) {
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);

        restaurant.updateInformation(name, address);
    }
}
