package com.mainpharmacy.laboratory.aplication;

import java.util.Optional;
import com.mainpharmacy.laboratory.domain.entity.Laboratory;
import com.mainpharmacy.laboratory.domain.service.LaboratoryService;

public class DeleteLaboratoryByNameUseCase {
    private final LaboratoryService LaboratoryService;

    public DeleteLaboratoryByNameUseCase(LaboratoryService LaboratoryService) {
        this.LaboratoryService = LaboratoryService;
    }

    public Optional<Laboratory> execute(String cityCode, String Name ) {
        return LaboratoryService.deleteLaboratoryByName(cityCode, Name);
    }
}
