package com.mainpharmacy.city.aplication;

import java.util.List;

import com.mainpharmacy.city.domain.entity.City;
import com.mainpharmacy.city.domain.service.CityService;

public class FindCityByRegionUseCase {
    private final CityService cityService;

    public FindCityByRegionUseCase(CityService cityService) {
        this.cityService = cityService;
    }

    public List<City> findAllCityByRegion(String RegionID) {
        return cityService.findAllCityByRegion(RegionID);
    }
}
