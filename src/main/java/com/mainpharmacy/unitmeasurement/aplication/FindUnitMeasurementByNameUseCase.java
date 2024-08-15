package com.mainpharmacy.unitmeasurement.aplication;

import java.util.Optional;

import com.mainpharmacy.unitmeasurement.domain.entity.UnitMeasurement;
import com.mainpharmacy.unitmeasurement.domain.service.UnitMeasurementService;

public class FindUnitMeasurementByNameUseCase {
    private final UnitMeasurementService unitmeasurementService;

    public FindUnitMeasurementByNameUseCase(UnitMeasurementService unitmeasurementService) {
        this.unitmeasurementService = unitmeasurementService;
    }

    public Optional<UnitMeasurement> findUnitMeasurementByName(String unitmeasurementName) {
        return unitmeasurementService.findUnitMeasurementByName(unitmeasurementName);
    }
}
