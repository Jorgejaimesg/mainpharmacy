package com.mainpharmacy.modeadministration.aplication;

import java.util.List;

import com.mainpharmacy.modeadministration.domain.entity.ModeAdministration;
import com.mainpharmacy.modeadministration.domain.service.ModeAdministrationService;

public class FindAllModeAdministrationUseCase {
    private final ModeAdministrationService modeadministrationService;

    public FindAllModeAdministrationUseCase(ModeAdministrationService modeadministrationService) {
        this.modeadministrationService = modeadministrationService;
    }

    public List<ModeAdministration> findAllModeAdministration() {
        return modeadministrationService.findAllModeAdministration();
    }
}
