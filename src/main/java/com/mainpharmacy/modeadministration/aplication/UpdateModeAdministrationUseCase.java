package com.mainpharmacy.modeadministration.aplication;

import com.mainpharmacy.modeadministration.domain.entity.ModeAdministration;
import com.mainpharmacy.modeadministration.domain.service.ModeAdministrationService;

public class UpdateModeAdministrationUseCase {
    private final ModeAdministrationService modeadministrationService;

    public UpdateModeAdministrationUseCase(ModeAdministrationService modeadministrationService){
        this.modeadministrationService = modeadministrationService;
    }

    public void execute(ModeAdministration modeadministration){
        modeadministrationService.updateModeAdministration(modeadministration);
    }
}
