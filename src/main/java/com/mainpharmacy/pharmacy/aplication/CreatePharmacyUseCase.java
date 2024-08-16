package com.mainpharmacy.pharmacy.aplication;

import com.mainpharmacy.pharmacy.domain.entity.Pharmacy;
import com.mainpharmacy.pharmacy.domain.service.PharmacyService;

public class CreatePharmacyUseCase {
    private final PharmacyService pharmacyService;

    public CreatePharmacyUseCase(PharmacyService pharmacyService){
        this.pharmacyService = pharmacyService;
    }

    public void execute(Pharmacy pharmacy){
        pharmacyService.createPharmacy(pharmacy);
}
}
