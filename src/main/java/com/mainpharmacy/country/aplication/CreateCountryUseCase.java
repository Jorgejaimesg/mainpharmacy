package com.mainpharmacy.country.aplication;

import com.mainpharmacy.country.domain.entity.Country;
import com.mainpharmacy.country.domain.service.CountryService;

public class CreateCountryUseCase {
    private final CountryService countryService;

    public CreateCountryUseCase(CountryService countryService){
        this.countryService = countryService;
    }

    public void execute(Country Country){
        countryService.createCountry(Country);
    }
}
