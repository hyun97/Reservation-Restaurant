package com.project.reservation.application;

import com.project.reservation.domain.Region;
import com.project.reservation.domain.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    private RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getRegions() {
        return regionRepository.findAll();
    }

    public Region addRegion(String name) {
        Region region = Region.builder().name(name).build();

        regionRepository.save(region);

        return region;
    }
}
