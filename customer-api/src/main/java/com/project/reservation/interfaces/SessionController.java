package com.project.reservation.interfaces;

import com.project.reservation.application.SessionResponseDTO;
import com.project.reservation.application.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class SessionController {

    private UserService userService;

    @Autowired
    public SessionController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/session")
    public ResponseEntity<SessionResponseDTO> create(
            @RequestBody SessionRequestDTO resource) throws URISyntaxException {
        String accessToken = "ACCESSTOKEN";

        String email = resource.getEmail();
        String password = resource.getPassword();
        userService.authenticate(email, password);

        return ResponseEntity.created(new URI("/session")).body(
                SessionResponseDTO.builder()
                        .accessToken(accessToken)
                        .build());
    }

}
