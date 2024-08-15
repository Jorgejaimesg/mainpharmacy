package com.mainpharmacy.unitmeasurement.aplication;

import com.mainpharmacy.unitmeasurement.domain.entity.UnitMeasurement;
import com.mainpharmacy.unitmeasurement.domain.service.UnitMeasurementService;

public class CreateUnitMeasurementUseCase {
    private final UnitMeasurementService modeAdministrationService;

    public CreateUnitMeasurementUseCase(UnitMeasurementService modeAdministrationService){
        this.modeAdministrationService = modeAdministrationService;
    }

    public void execute(UnitMeasurement UnitMeasurement){
        modeAdministrationService.createUnitMeasurement(UnitMeasurement);
    }
}
