package com.mainpharmacy.laboratory.aplication;

import java.util.Optional;

import com.mainpharmacy.laboratory.domain.entity.Laboratory;
import com.mainpharmacy.laboratory.domain.service.LaboratoryService;

public class FindLaboratoryByNameUseCase {
    private final LaboratoryService laboratoryService;

    public FindLaboratoryByNameUseCase(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public Optional<Laboratory> execute(String CityID, String Name ) {
        return laboratoryService.findLaboratoryByName(CityID, Name);
    }
}
