package com.mainpharmacy.region.aplication;

import java.util.List;

import com.mainpharmacy.region.domain.entity.Region;
import com.mainpharmacy.region.domain.service.RegionService;

public class FindRegionByCountryUseCase {
    private final RegionService regionService;

    public FindRegionByCountryUseCase(RegionService regionService) {
        this.regionService = regionService;
    }

    public List<Region> findAllRegionByCountry(String CountryID) {
        return regionService.findAllRegionByCountry(CountryID);
    }
}
