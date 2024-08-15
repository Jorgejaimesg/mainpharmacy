package com.mainpharmacy.city.aplication;

import java.util.List;

import com.mainpharmacy.city.domain.entity.City;
import com.mainpharmacy.city.domain.service.CityService;

public class FindLaboratoryByCityUseCase {
    private final CityService cityService;

    public FindLaboratoryByCityUseCase(CityService cityService) {
        this.cityService = cityService;
    }

    public List<City> findAllCityByRegion(String RegionID) {
        return cityService.findAllCityByRegion(RegionID);
    }
}
