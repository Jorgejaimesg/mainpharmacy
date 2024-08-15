package com.mainpharmacy.city.aplication;

import com.mainpharmacy.city.domain.entity.City;
import com.mainpharmacy.city.domain.service.CityService;

public class CreateCityUseCase {
    private final CityService cityService;

    public CreateCityUseCase(CityService cityService){
        this.cityService = cityService;
    }

    public void execute(City city){
        cityService.createCity(city);
}
}
