package com.mainpharmacy.laboratory.aplication;

import java.util.List;

import com.mainpharmacy.laboratory.domain.entity.LaboratoryShow;
import com.mainpharmacy.laboratory.domain.service.LaboratoryService;

public class FindAllLaboratoryUseCase {
        private final LaboratoryService laboratoryService;

    public FindAllLaboratoryUseCase(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public List<LaboratoryShow> findAllLaboratory() {
        return laboratoryService.findAllLaboratory();
    }

}
