package com.project.reservation.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTests {

    @Test
    public void creation() {
        User user = User.builder()
                .email("tester@example.com")
                .name("테스터")
                .level(3L)
                .build();

        assertThat(user.getEmail()).isEqualTo("tester@example.com");
        assertThat(user.isAdmin()).isTrue();
    }

}