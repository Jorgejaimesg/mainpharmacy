package com.mainpharmacy.laboratory.aplication;

import com.mainpharmacy.laboratory.domain.entity.Laboratory;
import com.mainpharmacy.laboratory.domain.service.LaboratoryService;

public class UpdateLaboratoryUseCase {
    private final LaboratoryService laboratoryService;

    public UpdateLaboratoryUseCase(LaboratoryService laboratoryService){
        this.laboratoryService = laboratoryService;
    }

    public void execute(Laboratory laboratory){
        laboratoryService.updateLaboratory(laboratory);
    }
}
