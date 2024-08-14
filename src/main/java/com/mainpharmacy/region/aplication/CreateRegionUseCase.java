package com.mainpharmacy.region.aplication;

import com.mainpharmacy.region.domain.entity.Region;
import com.mainpharmacy.region.domain.service.RegionService;

public class CreateRegionUseCase {
    private final RegionService regionService;

    public CreateRegionUseCase(RegionService regionService){
        this.regionService = regionService;
    }

    public void execute(Region region){
        regionService.createRegion(region);
}
}