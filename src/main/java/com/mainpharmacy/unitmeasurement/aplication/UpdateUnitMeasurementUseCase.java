package com.mainpharmacy.unitmeasurement.aplication;

import com.mainpharmacy.unitmeasurement.domain.entity.UnitMeasurement;
import com.mainpharmacy.unitmeasurement.domain.service.UnitMeasurementService;

public class UpdateUnitMeasurementUseCase {
    private final UnitMeasurementService unitmeasurementService;

    public UpdateUnitMeasurementUseCase(UnitMeasurementService unitmeasurementService){
        this.unitmeasurementService = unitmeasurementService;
    }

    public void execute(UnitMeasurement unitmeasurement){
        unitmeasurementService.updateUnitMeasurement(unitmeasurement);
    }
}
