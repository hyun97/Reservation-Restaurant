package com.project.reservation.interfaces;

import com.project.reservation.domain.Region;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegionController {

    @GetMapping("/regions")
    public List<Region> tmp() {
        return null;
    }
}
