package com.mainpharmacy.pharmacy.domain.service;

import java.util.List;
import java.util.Optional;

import com.mainpharmacy.pharmacy.domain.entity.Pharmacy;
import com.mainpharmacy.pharmacy.domain.entity.PharmacyShow;

public interface PharmacyService {
    void createPharmacy(Pharmacy Pharmacy);
    List<PharmacyShow> findAllPharmacy();
    List<Pharmacy> findAllPharmacyByCity(String CityID);
    Optional<Pharmacy> deletePharmacyByName(String CityID, String name);
    Optional<Pharmacy> findPharmacyByName(String CityID, String name);
    Optional<Pharmacy> findPharmacyByCode(int id);
    void updatePharmacy(Pharmacy Pharmacy);

}
