package com.project.reservation.application;

import com.project.reservation.domain.Region;
import com.project.reservation.domain.RegionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

class RegionServiceTests {

    private RegionService regionService;

    @Mock
    private RegionRepository regionRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        regionService = new RegionService(regionRepository);
    }

    @Test
    public void getRegions() {
        List<Region> mockRegion = regionService.getRegions();
        mockRegion.add(Region.builder().name("Seoul").build());

        given(regionRepository.findAll()).willReturn(mockRegion);

        List<Region> regions = regionService.getRegions();

        Region region = regions.get(0);
        assertThat(region.getName()).isEqualTo("Seoul");
    }

}