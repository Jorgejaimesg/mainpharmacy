package com.mainpharmacy.country.aplication;

import java.util.Optional;

import com.mainpharmacy.country.domain.entity.Country;
import com.mainpharmacy.country.domain.service.CountryService;

public class FindCountryByCodeUseCase {
    private final CountryService countryService;
    public FindCountryByCodeUseCase(CountryService countryService) {
        this.countryService = countryService;
    }

    public Optional<Country> findCountryByCode(String codeCountry) {
        return countryService.findCountryByCode(codeCountry);
    }
}
