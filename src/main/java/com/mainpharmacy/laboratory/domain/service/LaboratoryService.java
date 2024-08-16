package com.mainpharmacy.laboratory.domain.service;

import java.util.List;
import java.util.Optional;

import com.mainpharmacy.laboratory.domain.entity.Laboratory;
import com.mainpharmacy.laboratory.domain.entity.LaboratoryShow;

public interface LaboratoryService {
    void createLaboratory(Laboratory Laboratory);
    List<LaboratoryShow> findAllLaboratory();
    List<Laboratory> findAllLaboratoryByCity(String CityID);
    Optional<Laboratory> deleteLaboratoryByName(String CityID, String name);
    Optional<Laboratory> findLaboratoryByName(String CityID, String name);
    Optional<Laboratory> findLaboratoryByCode(int id);
    void updateLaboratory(Laboratory Laboratory);

}
