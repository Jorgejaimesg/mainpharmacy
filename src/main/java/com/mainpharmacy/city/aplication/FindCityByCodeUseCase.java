package com.mainpharmacy.city.aplication;

import java.util.Optional;

import com.mainpharmacy.city.domain.entity.City;
import com.mainpharmacy.city.domain.service.CityService;

public class FindCityByCodeUseCase {
    private final CityService cityService;

    public FindCityByCodeUseCase(CityService cityService) {
        this.cityService = cityService;
    }

    public Optional<City> findCityByCode(String CityBox) {
        return cityService.findCityByCode(CityBox);
    }
}
