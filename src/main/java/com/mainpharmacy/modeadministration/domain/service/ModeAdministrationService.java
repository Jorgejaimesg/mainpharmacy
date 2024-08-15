package com.mainpharmacy.modeadministration.domain.service;

import java.util.List;
import java.util.Optional;
import com.mainpharmacy.modeadministration.domain.entity.ModeAdministration;

public interface ModeAdministrationService {
    void createModeAdministration(ModeAdministration ModeAdministration);
    void updateModeAdministration(ModeAdministration ModeAdministration);
    ModeAdministration deleteModeAdministration(String name);
    Optional<ModeAdministration> findModeAdministrationByName (String name);
    Optional<ModeAdministration> findModeAdministrationByCode (int codeModeAdministration);
    List<ModeAdministration> findAllModeAdministration();
}
