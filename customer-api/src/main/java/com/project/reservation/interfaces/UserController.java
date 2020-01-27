package com.project.reservation.interfaces;

import com.project.reservation.application.UserService;
import com.project.reservation.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<?> create(@RequestBody User resource) throws URISyntaxException {
        String email = resource.getEmail();
        String name = resource.getName();
        String password = resource.getPassword();
//
//        User user = User.builder()
//                .id(1004L)
//                .email(email)
//                .name(name)
//                .password(password)
//                .build();

        User user = userService.registerUser(email, name, password);

        String url = "/users/" + user.getId();
        return ResponseEntity.created(new URI(url)).body("{}");
    }

}
