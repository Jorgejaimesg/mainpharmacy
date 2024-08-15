package com.mainpharmacy.unitmeasurement.aplication;

import com.mainpharmacy.unitmeasurement.domain.entity.UnitMeasurement;
import com.mainpharmacy.unitmeasurement.domain.service.UnitMeasurementService;

public class DeleteUnitMeasurementUseCase {
    private final UnitMeasurementService unitmeasurementService;

    public DeleteUnitMeasurementUseCase (UnitMeasurementService unitmeasurementService) {
        this.unitmeasurementService = unitmeasurementService;
    }

    public UnitMeasurement execute(String Name) {
        return unitmeasurementService.deleteUnitMeasurement(Name);
    }
}
