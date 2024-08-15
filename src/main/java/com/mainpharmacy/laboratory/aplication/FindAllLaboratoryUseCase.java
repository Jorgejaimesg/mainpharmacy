package com.mainpharmacy.city.aplication;

import java.util.List;

import com.mainpharmacy.city.domain.entity.CityShow;
import com.mainpharmacy.city.domain.service.CityService;

public class FindAllLaboratoryUseCase {
        private final CityService cityService;

    public FindAllLaboratoryUseCase(CityService cityService) {
        this.cityService = cityService;
    }

    public List<CityShow> findAllCity() {
        return cityService.findAllCity();
    }

}
