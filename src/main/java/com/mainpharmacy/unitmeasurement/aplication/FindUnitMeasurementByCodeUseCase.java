package com.mainpharmacy.unitmeasurement.aplication;

import java.util.Optional;

import com.mainpharmacy.unitmeasurement.domain.entity.UnitMeasurement;
import com.mainpharmacy.unitmeasurement.domain.service.UnitMeasurementService;

public class FindUnitMeasurementByCodeUseCase {
    private final UnitMeasurementService unitmeasurementService;
    public FindUnitMeasurementByCodeUseCase(UnitMeasurementService unitmeasurementService) {
        this.unitmeasurementService = unitmeasurementService;
    }

    public Optional<UnitMeasurement> findUnitMeasurementByCode(int codeUnitMeasurement) {
        return unitmeasurementService.findUnitMeasurementByCode(codeUnitMeasurement);
    }
}
