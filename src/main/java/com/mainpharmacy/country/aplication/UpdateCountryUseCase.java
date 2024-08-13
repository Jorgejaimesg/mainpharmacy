package com.mainpharmacy.country.aplication;

import com.mainpharmacy.country.domain.entity.Country;
import com.mainpharmacy.country.domain.service.CountryService;

public class UpdateCountryUseCase {
    private final CountryService countryService;

    public UpdateCountryUseCase(CountryService countryService){
        this.countryService = countryService;
    }

    public void execute(Country country){
        countryService.updateCountry(country);
    }
}
