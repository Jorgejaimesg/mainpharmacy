package com.mainpharmacy.region.aplication;

import com.mainpharmacy.region.domain.entity.Region;
import com.mainpharmacy.region.domain.service.RegionService;

public class UpdateRegionUseCase {
    private final RegionService regionService;

    public UpdateRegionUseCase(RegionService regionService){
        this.regionService = regionService;
    }

    public void execute(Region region){
        regionService.updateRegion(region);
    }
}
