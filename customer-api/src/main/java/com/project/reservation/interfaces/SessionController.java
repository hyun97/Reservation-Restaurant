package com.project.reservation.interfaces;

import com.project.reservation.application.SessionResponseDTO;
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
public class SessionController {

    private UserService userService;

    @Autowired
    public SessionController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/session")
    public ResponseEntity<SessionResponseDTO> create(
            @RequestBody SessionRequestDTO resource) throws URISyntaxException {
        String email = resource.getEmail();
        String password = resource.getPassword();

        User user = userService.authenticate(email, password);

        String accessToken = user.getAccessToken();

        return ResponseEntity.created(new URI("/session")).body(
                SessionResponseDTO.builder()
                        .accessToken(accessToken)
                        .build());
    }

}
