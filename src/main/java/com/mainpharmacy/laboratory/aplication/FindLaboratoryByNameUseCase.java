package com.mainpharmacy.city.aplication;

import java.util.Optional;

import com.mainpharmacy.city.domain.entity.City;
import com.mainpharmacy.city.domain.service.CityService;

public class FindLaboratoryByNameUseCase {
    private final CityService cityService;

    public FindLaboratoryByNameUseCase(CityService cityService) {
        this.cityService = cityService;
    }

    public Optional<City> execute(String RegionID, String Name ) {
        return cityService.findCityByName(RegionID, Name);
    }
}
