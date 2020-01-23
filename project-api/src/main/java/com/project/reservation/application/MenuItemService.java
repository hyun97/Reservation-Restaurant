package com.project.reservation.application;

import com.project.reservation.domain.MenuItem;
import com.project.reservation.domain.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    private MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public void bulkUpdate(Long id, List<MenuItem> menuItems) {
        for (MenuItem menuItem : menuItems) {
            menuItem.setRestaurantId(id);
            menuItemRepository.save(menuItem);
        }
    }

}
