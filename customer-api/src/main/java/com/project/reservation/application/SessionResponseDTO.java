package com.project.reservation.application;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SessionResponseDTO {

    private String accessToken;

}
