package com.mainpharmacy.pharmacy.aplication;

import java.util.List;

import com.mainpharmacy.pharmacy.domain.entity.PharmacyShow;
import com.mainpharmacy.pharmacy.domain.service.PharmacyService;

public class FindAllPharmacyUseCase {
        private final PharmacyService pharmacyService;

    public FindAllPharmacyUseCase(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    public List<PharmacyShow> findAllPharmacy() {
        return pharmacyService.findAllPharmacy();
    }

}
