package com.project.reservation.interfaces;

import com.project.reservation.application.MenuItemService;
import com.project.reservation.domain.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @PatchMapping("/restaurants/{id}/menuItems")
    public String bulkUpdate(@PathVariable("id") Long id, @RequestBody List<MenuItem> menuItems) {
        menuItemService.bulkUpdate(id, menuItems);

        return "";
    }
}
