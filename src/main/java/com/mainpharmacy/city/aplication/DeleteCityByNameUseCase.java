package com.mainpharmacy.city.aplication;

import java.util.Optional;
import com.mainpharmacy.city.domain.entity.City;
import com.mainpharmacy.city.domain.service.CityService;

public class DeleteCityByNameUseCase {
    private final CityService CityService;

    public DeleteCityByNameUseCase(CityService CityService) {
        this.CityService = CityService;
    }

    public Optional<City> execute(String regionCode, String Name ) {
        return CityService.deleteCityByName(regionCode, Name);
    }
}
