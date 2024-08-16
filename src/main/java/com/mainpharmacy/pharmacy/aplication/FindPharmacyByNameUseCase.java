package com.mainpharmacy.pharmacy.aplication;

import java.util.Optional;

import com.mainpharmacy.pharmacy.domain.entity.Pharmacy;
import com.mainpharmacy.pharmacy.domain.service.PharmacyService;

public class FindPharmacyByNameUseCase {
    private final PharmacyService pharmacyService;

    public FindPharmacyByNameUseCase(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    public Optional<Pharmacy> execute(String CityID, String Name ) {
        return pharmacyService.findPharmacyByName(CityID, Name);
    }
}
