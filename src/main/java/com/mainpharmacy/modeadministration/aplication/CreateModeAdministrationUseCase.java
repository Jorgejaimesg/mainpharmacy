package com.mainpharmacy.modeadministration.aplication;

import com.mainpharmacy.modeadministration.domain.entity.ModeAdministration;
import com.mainpharmacy.modeadministration.domain.service.ModeAdministrationService;

public class CreateModeAdministrationUseCase {
    private final ModeAdministrationService modeAdministrationService;

    public CreateModeAdministrationUseCase(ModeAdministrationService modeAdministrationService){
        this.modeAdministrationService = modeAdministrationService;
    }

    public void execute(ModeAdministration ModeAdministration){
        modeAdministrationService.createModeAdministration(ModeAdministration);
    }
}
