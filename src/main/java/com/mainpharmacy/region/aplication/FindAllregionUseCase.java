package com.mainpharmacy.region.aplication;

import java.util.List;

import com.mainpharmacy.region.domain.entity.Region;
import com.mainpharmacy.region.domain.service.RegionService;


public class FindAllregionUseCase {
    private final RegionService regionService;

    public FindAllregionUseCase(RegionService regionService) {
        this.regionService = regionService;
    }

    public List<Region> findAllRegion() {
        return regionService.findAllRegion();
    }

    }
