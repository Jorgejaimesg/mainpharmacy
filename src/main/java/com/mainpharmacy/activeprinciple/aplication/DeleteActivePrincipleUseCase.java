package com.mainpharmacy.activeprinciple.aplication;

import com.mainpharmacy.activeprinciple.domain.entity.ActivePrinciple;
import com.mainpharmacy.activeprinciple.domain.service.ActivePrincipleService;

public class DeleteActivePrincipleUseCase {
    private final ActivePrincipleService activeprincipleService;

    public DeleteActivePrincipleUseCase (ActivePrincipleService activeprincipleService) {
        this.activeprincipleService = activeprincipleService;
    }

    public ActivePrinciple execute(String Name) {
        return activeprincipleService.deleteActivePrinciple(Name);
    }
}
