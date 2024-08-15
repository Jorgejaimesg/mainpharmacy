package com.mainpharmacy.activeprinciple.aplication;

import java.util.Optional;

import com.mainpharmacy.activeprinciple.domain.entity.ActivePrinciple;
import com.mainpharmacy.activeprinciple.domain.service.ActivePrincipleService;

public class FindActivePrincipleByCodeUseCase {
    private final ActivePrincipleService activeprincipleService;
    public FindActivePrincipleByCodeUseCase(ActivePrincipleService activeprincipleService) {
        this.activeprincipleService = activeprincipleService;
    }

    public Optional<ActivePrinciple> findActivePrincipleByCode(int codeActivePrinciple) {
        return activeprincipleService.findActivePrincipleByCode(codeActivePrinciple);
    }
}
