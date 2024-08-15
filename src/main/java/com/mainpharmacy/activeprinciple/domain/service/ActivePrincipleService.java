package com.mainpharmacy.activeprinciple.domain.service;

import java.util.List;
import java.util.Optional;
import com.mainpharmacy.activeprinciple.domain.entity.ActivePrinciple;

public interface ActivePrincipleService {
    void createActivePrinciple(ActivePrinciple ActivePrinciple);
    void updateActivePrinciple(ActivePrinciple ActivePrinciple);
    ActivePrinciple deleteActivePrinciple(String name);
    Optional<ActivePrinciple> findActivePrincipleByName (String name);
    Optional<ActivePrinciple> findActivePrincipleByCode (int codeActivePrinciple);
    List<ActivePrinciple> findAllActivePrinciple();
}
