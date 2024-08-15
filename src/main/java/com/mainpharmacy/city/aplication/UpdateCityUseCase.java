package com.mainpharmacy.city.aplication;

import com.mainpharmacy.city.domain.entity.City;
import com.mainpharmacy.city.domain.service.CityService;

public class UpdateCityUseCase {
    private final CityService cityService;

    public UpdateCityUseCase(CityService cityService){
        this.cityService = cityService;
    }

    public void execute(City city){
        cityService.updateCity(city);
    }
}
