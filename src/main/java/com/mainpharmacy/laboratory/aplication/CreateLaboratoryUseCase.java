package com.mainpharmacy.laboratory.aplication;

import com.mainpharmacy.laboratory.domain.entity.Laboratory;
import com.mainpharmacy.laboratory.domain.service.LaboratoryService;

public class CreateLaboratoryUseCase {
    private final LaboratoryService laboratoryService;

    public CreateLaboratoryUseCase(LaboratoryService laboratoryService){
        this.laboratoryService = laboratoryService;
    }

    public void execute(Laboratory laboratory){
        laboratoryService.createLaboratory(laboratory);
}
}
