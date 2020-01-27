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
        assertThat(user.isActive()).isTrue();

        user.deactivate();

        assertThat(user.isActive()).isFalse();
    }

    @Test
    public void accessTokenWithPassword() {
        User user = User.builder().password("ACCESSTOKEN").build();

        assertThat(user.getAccessToken()).isEqualTo("ACCESSTOKE");
    }

    @Test
    public void accessTokenWithoutPassword() {
        User user = new User();

        assertThat(user.getAccessToken()).isEqualTo("");
    }

}