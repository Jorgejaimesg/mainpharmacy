package com.mainpharmacy.modeadministration.aplication;

import com.mainpharmacy.modeadministration.domain.entity.ModeAdministration;
import com.mainpharmacy.modeadministration.domain.service.ModeAdministrationService;

public class DeleteModeAdministrationUseCase {
    private final ModeAdministrationService modeadministrationService;

    public DeleteModeAdministrationUseCase (ModeAdministrationService modeadministrationService) {
        this.modeadministrationService = modeadministrationService;
    }

    public ModeAdministration execute(String Name) {
        return modeadministrationService.deleteModeAdministration(Name);
    }
}
