package com.mainpharmacy.activeprinciple.aplication;

import java.util.Optional;

import com.mainpharmacy.activeprinciple.domain.entity.ActivePrinciple;
import com.mainpharmacy.activeprinciple.domain.service.ActivePrincipleService;

public class FindActivePrincipleByNameUseCase {
    private final ActivePrincipleService activeprincipleService;

    public FindActivePrincipleByNameUseCase(ActivePrincipleService activeprincipleService) {
        this.activeprincipleService = activeprincipleService;
    }

    public Optional<ActivePrinciple> findActivePrincipleByName(String activeprincipleName) {
        return activeprincipleService.findActivePrincipleByName(activeprincipleName);
    }
}
