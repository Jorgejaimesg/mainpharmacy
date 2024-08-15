package com.mainpharmacy.modeadministration.aplication;

import java.util.Optional;

import com.mainpharmacy.modeadministration.domain.entity.ModeAdministration;
import com.mainpharmacy.modeadministration.domain.service.ModeAdministrationService;

public class FindModeAdministrationByNameUseCase {
    private final ModeAdministrationService modeadministrationService;

    public FindModeAdministrationByNameUseCase(ModeAdministrationService modeadministrationService) {
        this.modeadministrationService = modeadministrationService;
    }

    public Optional<ModeAdministration> findModeAdministrationByName(String modeadministrationName) {
        return modeadministrationService.findModeAdministrationByName(modeadministrationName);
    }
}
