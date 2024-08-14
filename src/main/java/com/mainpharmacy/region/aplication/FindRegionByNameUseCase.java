package com.mainpharmacy.region.aplication;

import java.util.Optional;

import com.mainpharmacy.region.domain.entity.Region;
import com.mainpharmacy.region.domain.service.RegionService;

public class FindRegionByNameUseCase {
        private final RegionService regionService;

    public FindRegionByNameUseCase(RegionService regionService) {
        this.regionService = regionService;
    }

    public Optional<Region> execute(String Country, String Name ) {
        return regionService.findRegionByName(Country, Name);
    }
}
