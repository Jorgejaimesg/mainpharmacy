package com.mainpharmacy.pharmacy.aplication;

import java.util.Optional;
import com.mainpharmacy.pharmacy.domain.entity.Pharmacy;
import com.mainpharmacy.pharmacy.domain.service.PharmacyService;

public class DeletePharmacyByNameUseCase {
    private final PharmacyService PharmacyService;

    public DeletePharmacyByNameUseCase(PharmacyService PharmacyService) {
        this.PharmacyService = PharmacyService;
    }

    public Optional<Pharmacy> execute(String cityCode, String Name ) {
        return PharmacyService.deletePharmacyByName(cityCode, Name);
    }
}
