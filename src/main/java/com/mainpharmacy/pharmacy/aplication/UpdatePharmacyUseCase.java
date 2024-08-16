package com.mainpharmacy.pharmacy.aplication;

import com.mainpharmacy.pharmacy.domain.entity.Pharmacy;
import com.mainpharmacy.pharmacy.domain.service.PharmacyService;

public class UpdatePharmacyUseCase {
    private final PharmacyService pharmacyService;

    public UpdatePharmacyUseCase(PharmacyService pharmacyService){
        this.pharmacyService = pharmacyService;
    }

    public void execute(Pharmacy pharmacy){
        pharmacyService.updatePharmacy(pharmacy);
    }
}
