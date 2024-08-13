package com.mainpharmacy.country.aplication;

import java.util.Optional;

import com.mainpharmacy.country.domain.entity.Country;
import com.mainpharmacy.country.domain.service.CountryService;

public class FindCountryByNameUseCase {
    private final CountryService countryService;

    public FindCountryByNameUseCase(CountryService countryService) {
        this.countryService = countryService;
    }

    public Optional<Country> findCountryByName(String countryName) {
        return countryService.findCountryByName(countryName);
    }
}
