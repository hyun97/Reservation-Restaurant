package com.project.reservation.application;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SessionDTO {

    private String accessToken;

}
