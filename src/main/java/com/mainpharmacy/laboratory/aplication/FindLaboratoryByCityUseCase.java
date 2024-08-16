package com.mainpharmacy.laboratory.aplication;

import java.util.List;

import com.mainpharmacy.laboratory.domain.entity.Laboratory;
import com.mainpharmacy.laboratory.domain.service.LaboratoryService;

public class FindLaboratoryByCityUseCase {
    private final LaboratoryService laboratoryService;

    public FindLaboratoryByCityUseCase(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public List<Laboratory> findAllLaboratoryByCity(String CityID) {
        return laboratoryService.findAllLaboratoryByCity(CityID);
    }
}
