package com.mainpharmacy.activeprinciple.aplication;

import com.mainpharmacy.activeprinciple.domain.entity.ActivePrinciple;
import com.mainpharmacy.activeprinciple.domain.service.ActivePrincipleService;

public class CreateActivePrincipleUseCase {
    private final ActivePrincipleService modeAdministrationService;

    public CreateActivePrincipleUseCase(ActivePrincipleService modeAdministrationService){
        this.modeAdministrationService = modeAdministrationService;
    }

    public void execute(ActivePrinciple ActivePrinciple){
        modeAdministrationService.createActivePrinciple(ActivePrinciple);
    }
}
