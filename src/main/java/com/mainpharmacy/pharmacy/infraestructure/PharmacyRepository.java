package com.mainpharmacy.pharmacy.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.mainpharmacy.pharmacy.domain.entity.Pharmacy;
import com.mainpharmacy.pharmacy.domain.entity.PharmacyShow;
import com.mainpharmacy.pharmacy.domain.service.PharmacyService;


public class PharmacyRepository implements PharmacyService{
    
        private Connection connection;
        public PharmacyRepository() {
            try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("mainpharmacy.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        @Override
        public void createPharmacy(Pharmacy Pharmacy) {
            try {
            String query = "INSERT INTO pharmacy (idfarmacy, namefarmacy, addressfarmacy, longfarmacy, latfarmacy, codecityfarm, logofarmacy) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, Pharmacy.getIdpharmacy());
            ps.setString(2, Pharmacy.getNamepharmacy());
            ps.setString(3, Pharmacy.getAddrespharmacy());
            ps.setString(4, Pharmacy.getLongfarmacy());
            ps.setString(5, Pharmacy.getLatpharmacy());
            ps.setString(6, Pharmacy.getCodecity());
            ps.setString(7, Pharmacy.getLogopharmacy());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        @Override
        public List<PharmacyShow> findAllPharmacy() {
            List<PharmacyShow> laboratories = new ArrayList<>();
            String query = "SELECT l.idfarmacy, l.namefarmacy, l.addressfarmacy ,c.namecity As City ,r.namereg AS Region, co.namecountry as Country FROM Pharmacy l  JOIN city c ON c.codecity = l.codecityfarm JOIN region r ON r.codereg = c.codereg JOIN country co ON co.codecountry = r.codecountry";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        PharmacyShow Pharmacyshow = new PharmacyShow(
                                rs.getInt("idfarmacy"),
                                rs.getString("namefarmacy"),
                                rs.getString("addressfarmacy"),
                                rs.getString("City"),
                                rs.getString("Region"),
                                rs.getString("Country"));
                                laboratories.add(Pharmacyshow);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return laboratories;
        }
        @Override
        public List<Pharmacy> findAllPharmacyByCity(String CityID) {
            List<Pharmacy> pharmacies = new ArrayList<>();
            String query = "SELECT idfarmacy, namefarmacy, addressfarmacy, longfarmacy, latfarmacy, logofarmacy FROM Pharmacy where codecityfarm = ?";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, CityID);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Pharmacy pharmacy = new Pharmacy(
                                rs.getInt("idfarmacy"),
                                rs.getString("namefarmacy"),
                                rs.getString("addressfarmacy"),
                                rs.getString("longfarmacy"),
                                rs.getString("latfarmacy"),
                                rs.getString("logofarmacy"), CityID);
                                pharmacies.add(pharmacy);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return pharmacies;
        }
        @Override
        public Optional<Pharmacy> deletePharmacyByName(String CityID, String name) {
            String query = "DELETE FROM pharmacy WHERE (codecityfarm = ? && namefarmacy = ?)";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, CityID);
                ps.setString(2, name);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        public Optional<Pharmacy> findPharmacyByName(String CityID, String name) {
            String query = "SELECT idfarmacy, namefarmacy, codecityfarm, addressfarmacy, longfarmacy, latfarmacy, logofarmacy FROM pharmacy WHERE (codecityfarm = ? && namefarmacy = ?)";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, CityID);
                ps.setString(2, name);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Pharmacy pharmacy = new Pharmacy(
                                rs.getInt("idfarmacy"),
                                rs.getString("namefarmacy"),
                                rs.getString("codecityfarm"),
                                rs.getString("addressfarmacy"),
                                rs.getString("longfarmacy"),
                                rs.getString("latfarmacy"),
                                rs.getString("logofarmacy"));
                        return Optional.of(pharmacy);
                    }
    
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Optional.empty();
        }
        @Override
        public Optional<Pharmacy> findPharmacyByCode(int PharmacyID) {
            String query = "SELECT idfarmacy, namefarmacy, codecityfarm, addressfarmacy, longfarmacy, latfarmacy, logofarmacy FROM Pharmacy WHERE idfarmacy=?";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, PharmacyID);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Pharmacy Pharmacy = new Pharmacy(
                            rs.getInt("idfarmacy"),
                            rs.getString("namefarmacy"),
                            rs.getString("codecityfarm"),
                            rs.getString("addressfarmacy"),
                            rs.getString("longfarmacy"),
                            rs.getString("latfarmacy"),
                            rs.getString("logofarmacy"));
                        return Optional.of(Pharmacy);
                    }
    
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Optional.empty();
        
        }
        @Override
        public void updatePharmacy(Pharmacy Pharmacy) {
            String query = "UPDATE Pharmacy SET namefarmacy = ?, addressfarmacy = ?, longfarmacy = ?, latfarmacy = ?, codecityfarm = ?, logofarmacy = ? WHERE idfarmacy = ?";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, Pharmacy.getNamepharmacy());
                ps.setString(2, Pharmacy.getAddrespharmacy());
                ps.setString(3, Pharmacy.getLongfarmacy());
                ps.setString(4, Pharmacy.getLatpharmacy());
                ps.setString(5, Pharmacy.getCodecity());
                ps.setString(6, Pharmacy.getLogopharmacy());
                ps.setInt(7, Pharmacy.getIdpharmacy());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } 
        }
    
