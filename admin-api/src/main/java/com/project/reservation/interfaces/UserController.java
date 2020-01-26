package com.project.reservation.interfaces;

import com.project.reservation.application.UserService;
import com.project.reservation.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    // 1. User list
    // 2. User create -> 회원가입
    // 3. User update
    // 4. User delete -> Level: 0 => 아무것도 못함
    // ( 1. customer, 2. restaurant owner, 3. admin )

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> list() {
        return userService.getUsers();
    }

}
