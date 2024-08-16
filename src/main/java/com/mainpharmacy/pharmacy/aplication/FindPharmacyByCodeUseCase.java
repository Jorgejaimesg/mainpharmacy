package com.mainpharmacy.pharmacy.aplication;

import java.util.Optional;

import com.mainpharmacy.pharmacy.domain.entity.Pharmacy;
import com.mainpharmacy.pharmacy.domain.service.PharmacyService;

public class FindPharmacyByCodeUseCase {
    private final PharmacyService pharmacyService;

    public FindPharmacyByCodeUseCase(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    public Optional<Pharmacy> findPharmacyByCode(int id) {
        return pharmacyService.findPharmacyByCode(id);
    }
}
