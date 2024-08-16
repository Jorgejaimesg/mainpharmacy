package com.mainpharmacy.pharmacy.aplication;

import java.util.List;

import com.mainpharmacy.pharmacy.domain.entity.Pharmacy;
import com.mainpharmacy.pharmacy.domain.service.PharmacyService;

public class FindPharmacyByCityUseCase {
    private final PharmacyService pharmacyService;

    public FindPharmacyByCityUseCase(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    public List<Pharmacy> findAllPharmacyByCity(String CityID) {
        return pharmacyService.findAllPharmacyByCity(CityID);
    }
}
