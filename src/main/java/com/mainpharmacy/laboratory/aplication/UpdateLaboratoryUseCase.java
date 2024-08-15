package com.mainpharmacy.city.aplication;

import com.mainpharmacy.city.domain.entity.City;
import com.mainpharmacy.city.domain.service.CityService;

public class UpdateLaboratoryUseCase {
    private final CityService cityService;

    public UpdateLaboratoryUseCase(CityService cityService){
        this.cityService = cityService;
    }

    public void execute(City city){
        cityService.updateCity(city);
    }
}
