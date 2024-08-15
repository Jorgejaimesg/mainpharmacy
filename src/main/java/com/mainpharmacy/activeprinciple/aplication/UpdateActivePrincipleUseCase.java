package com.mainpharmacy.activeprinciple.aplication;

import com.mainpharmacy.activeprinciple.domain.entity.ActivePrinciple;
import com.mainpharmacy.activeprinciple.domain.service.ActivePrincipleService;

public class UpdateActivePrincipleUseCase {
    private final ActivePrincipleService activeprincipleService;

    public UpdateActivePrincipleUseCase(ActivePrincipleService activeprincipleService){
        this.activeprincipleService = activeprincipleService;
    }

    public void execute(ActivePrinciple activeprinciple){
        activeprincipleService.updateActivePrinciple(activeprinciple);
    }
}
