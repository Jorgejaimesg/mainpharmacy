package com.mainpharmacy.unitmeasurement.aplication;

import java.util.List;

import com.mainpharmacy.unitmeasurement.domain.entity.UnitMeasurement;
import com.mainpharmacy.unitmeasurement.domain.service.UnitMeasurementService;

public class FindAllUnitMeasurementUseCase {
    private final UnitMeasurementService unitmeasurementService;

    public FindAllUnitMeasurementUseCase(UnitMeasurementService unitmeasurementService) {
        this.unitmeasurementService = unitmeasurementService;
    }

    public List<UnitMeasurement> findAllUnitMeasurement() {
        return unitmeasurementService.findAllUnitMeasurement();
    }
}
