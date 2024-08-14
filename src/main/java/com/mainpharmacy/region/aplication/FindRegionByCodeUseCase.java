package com.mainpharmacy.region.aplication;

import java.util.Optional;

import com.mainpharmacy.region.domain.entity.Region;
import com.mainpharmacy.region.domain.service.RegionService;

public class FindRegionByCodeUseCase {
            private final RegionService regionService;

    public FindRegionByCodeUseCase(RegionService regionService) {
        this.regionService = regionService;
    }

    public Optional<Region> findRegionByID(String regionBox) {
        return regionService.findRegionByID(regionBox);
    }
}
