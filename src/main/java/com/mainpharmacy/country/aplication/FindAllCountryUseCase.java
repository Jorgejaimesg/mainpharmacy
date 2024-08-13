package com.mainpharmacy.country.aplication;

import java.util.List;

import com.mainpharmacy.country.domain.entity.Country;
import com.mainpharmacy.country.domain.service.CountryService;

public class FindAllCountryUseCase {
    private final CountryService countryService;

    public FindAllCountryUseCase(CountryService countryService) {
        this.countryService = countryService;
    }

    public List<Country> findAllCountry() {
        return countryService.findAllCountry();
    }
}
