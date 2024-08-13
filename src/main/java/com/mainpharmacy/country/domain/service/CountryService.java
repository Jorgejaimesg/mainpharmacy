package com.mainpharmacy.country.domain.service;

import java.util.List;
import java.util.Optional;

import com.mainpharmacy.country.domain.entity.Country;

public interface CountryService {
    void createCountry(Country country);
    void updateCountry(Country country);
    Country deleteCountry(String name);
    Optional<Country> findCountryByName (String name);
    Optional<Country> findCountryByCode (String codeCountry);
    List<Country> findAllCountry();
}
