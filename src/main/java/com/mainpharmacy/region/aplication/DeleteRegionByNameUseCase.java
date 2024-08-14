package com.mainpharmacy.region.aplication;

import com.mainpharmacy.region.domain.entity.Region;
import com.mainpharmacy.region.domain.service.RegionService;
import java.util.Optional;

public class DeleteRegionByNameUseCase {
    private final RegionService regionService;

    public DeleteRegionByNameUseCase(RegionService regionService) {
        this.regionService = regionService;
    }

    public Optional<Region> execute(String countryCode, String Name ) {
        return regionService.deleteRegionByName(countryCode, Name);
    }
}
