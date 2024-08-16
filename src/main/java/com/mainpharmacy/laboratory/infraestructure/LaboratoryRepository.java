package com.mainpharmacy.laboratory.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.mainpharmacy.laboratory.domain.entity.Laboratory;
import com.mainpharmacy.laboratory.domain.entity.LaboratoryShow;
import com.mainpharmacy.laboratory.domain.service.LaboratoryService;


public class LaboratoryRepository implements LaboratoryService{
    
        private Connection connection;
        public LaboratoryRepository() {
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
        public void createLaboratory(Laboratory Laboratory) {
            try {
            String query = "INSERT INTO laboratory (id, namelab, codecityreg) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, Laboratory.getId());
            ps.setString(2, Laboratory.getNamelab());
            ps.setString(3, Laboratory.getCodecity());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        @Override
        public List<LaboratoryShow> findAllLaboratory() {
            List<LaboratoryShow> laboratories = new ArrayList<>();
            String query = "SELECT l.id, l.namelab ,c.namecity As City ,r.namereg AS Region, co.namecountry as Country FROM Laboratory l  JOIN city c ON c.codecity = l.codecityreg JOIN region r ON r.codereg = c.codereg JOIN country co ON co.codecountry = r.codecountry";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        LaboratoryShow Laboratoryshow = new LaboratoryShow(
                                rs.getInt("id"),
                                rs.getString("namelab"),
                                rs.getString("City"),
                                rs.getString("Region"),
                                rs.getString("Country"));
                                laboratories.add(Laboratoryshow);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return laboratories;
        }
        @Override
        public List<Laboratory> findAllLaboratoryByCity(String CityID) {
            List<Laboratory> Cities = new ArrayList<>();
            String query = "SELECT id, namelab FROM Laboratory where codecityreg = ?";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, CityID);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Laboratory laboratory = new Laboratory(
                                rs.getInt("id"),
                                rs.getString("namelab"), CityID);
                                Cities.add(laboratory);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Cities;
        }
        @Override
        public Optional<Laboratory> deleteLaboratoryByName(String CityID, String name) {
            String query = "DELETE FROM laboratory WHERE (codecityreg = ? && namelab = ?)";
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
        public Optional<Laboratory> findLaboratoryByName(String CityID, String name) {
            String query = "SELECT id, namelab, codecityreg FROM laboratory WHERE (codecityreg = ? && namelab = ?)";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, CityID);
                ps.setString(2, name);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Laboratory laboratory = new Laboratory(
                                rs.getInt("id"),
                                rs.getString("namelab"),
                                rs.getString("codecityreg"));
                        return Optional.of(laboratory);
                    }
    
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Optional.empty();
        }
        @Override
        public Optional<Laboratory> findLaboratoryByCode(int LaboratoryID) {
            String query = "SELECT id, namelab, codecityreg FROM Laboratory WHERE id=?";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, LaboratoryID);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Laboratory Laboratory = new Laboratory(
                                rs.getInt("id"),
                                rs.getString("namelab"),
                                rs.getString("codecityreg"));
                        return Optional.of(Laboratory);
                    }
    
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Optional.empty();
        
        }
        @Override
        public void updateLaboratory(Laboratory Laboratory) {
            String query = "UPDATE Laboratory SET codecityreg = ?, namelab = ? WHERE id = ?";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, Laboratory.getCodecity());
                ps.setString(2, Laboratory.getNamelab());
                ps.setInt(3, Laboratory.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } 
        }
    
