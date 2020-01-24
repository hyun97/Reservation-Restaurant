package com.project.reservation.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RegionTests {

    @Test
    public void creation() {
        Region region = Region.builder().name("서울").build();

        assertThat(region.getName()).isEqualTo("서울");
    }

}