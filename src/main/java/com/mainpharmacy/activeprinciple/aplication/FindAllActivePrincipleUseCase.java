package com.mainpharmacy.activeprinciple.aplication;

import java.util.List;

import com.mainpharmacy.activeprinciple.domain.entity.ActivePrinciple;
import com.mainpharmacy.activeprinciple.domain.service.ActivePrincipleService;

public class FindAllActivePrincipleUseCase {
    private final ActivePrincipleService activeprincipleService;

    public FindAllActivePrincipleUseCase(ActivePrincipleService activeprincipleService) {
        this.activeprincipleService = activeprincipleService;
    }

    public List<ActivePrinciple> findAllActivePrinciple() {
        return activeprincipleService.findAllActivePrinciple();
    }
}
