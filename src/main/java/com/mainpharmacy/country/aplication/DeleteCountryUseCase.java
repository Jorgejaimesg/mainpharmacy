package com.mainpharmacy.country.aplication;

import com.mainpharmacy.country.domain.entity.Country;
import com.mainpharmacy.country.domain.service.CountryService;

public class DeleteCountryUseCase {
    private final CountryService countryService;

    public DeleteCountryUseCase (CountryService countryService) {
        this.countryService = countryService;
    }

    public Country execute(String Name) {
        return countryService.deleteCountry(Name);
    }
}
