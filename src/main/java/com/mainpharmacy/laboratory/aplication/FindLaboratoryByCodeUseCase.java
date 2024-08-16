package com.mainpharmacy.laboratory.aplication;

import java.util.Optional;

import com.mainpharmacy.laboratory.domain.entity.Laboratory;
import com.mainpharmacy.laboratory.domain.service.LaboratoryService;

public class FindLaboratoryByCodeUseCase {
    private final LaboratoryService laboratoryService;

    public FindLaboratoryByCodeUseCase(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public Optional<Laboratory> findLaboratoryByCode(int id) {
        return laboratoryService.findLaboratoryByCode(id);
    }
}
