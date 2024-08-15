package com.mainpharmacy.unitmeasurement.domain.service;

import java.util.List;
import java.util.Optional;
import com.mainpharmacy.unitmeasurement.domain.entity.UnitMeasurement;

public interface UnitMeasurementService {
    void createUnitMeasurement(UnitMeasurement UnitMeasurement);
    void updateUnitMeasurement(UnitMeasurement UnitMeasurement);
    UnitMeasurement deleteUnitMeasurement(String name);
    Optional<UnitMeasurement> findUnitMeasurementByName (String name);
    Optional<UnitMeasurement> findUnitMeasurementByCode (int codeUnitMeasurement);
    List<UnitMeasurement> findAllUnitMeasurement();
}
