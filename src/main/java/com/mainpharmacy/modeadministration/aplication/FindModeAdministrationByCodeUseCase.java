package com.mainpharmacy.modeadministration.aplication;

import java.util.Optional;

import com.mainpharmacy.modeadministration.domain.entity.ModeAdministration;
import com.mainpharmacy.modeadministration.domain.service.ModeAdministrationService;

public class FindModeAdministrationByCodeUseCase {
    private final ModeAdministrationService modeadministrationService;
    public FindModeAdministrationByCodeUseCase(ModeAdministrationService modeadministrationService) {
        this.modeadministrationService = modeadministrationService;
    }

    public Optional<ModeAdministration> findModeAdministrationByCode(int codeModeAdministration) {
        return modeadministrationService.findModeAdministrationByCode(codeModeAdministration);
    }
}
