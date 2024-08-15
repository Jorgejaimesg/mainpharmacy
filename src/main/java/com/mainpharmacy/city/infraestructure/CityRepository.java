package com.mainpharmacy.city.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.mainpharmacy.city.domain.entity.City;
import com.mainpharmacy.city.domain.entity.CityShow;
import com.mainpharmacy.city.domain.service.CityService;


public class CityRepository implements CityService{
    
        private Connection connection;
        public CityRepository() {
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
        public void createCity(City City) {
            try {
            String query = "INSERT INTO city (codecity, namecity, codereg) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, City.getCodecity());
            ps.setString(2, City.getNamecity());
            ps.setString(3, City.getCodereg());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        @Override
        public List<CityShow> findAllCity() {
            List<CityShow> cities = new ArrayList<>();
            String query = "SELECT c.codecity, c.namecity , r.namereg AS region, co.namecountry as Country FROM City c  JOIN region r ON r.codereg = c.codereg JOIN country co ON co.codecountry = r.codecountry";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        CityShow Cityshow = new CityShow(
                                rs.getString("codecity"),
                                rs.getString("namecity"),
                                rs.getString("region"),
                                rs.getString("Country"));
                                cities.add(Cityshow);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return cities;
        }
        @Override
        public List<City> findAllCityByRegion(String RegionID) {
            List<City> Cities = new ArrayList<>();
            String query = "SELECT codecity, namecity FROM City where codereg = ?";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, RegionID);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        City city = new City(
                                rs.getString("codecity"),
                                rs.getString("namecity"), RegionID);
                                Cities.add(city);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Cities;
        }
        @Override
        public Optional<City> deleteCityByName(String RegionID, String name) {
            String query = "DELETE FROM city WHERE (codereg = ? && namecity = ?)";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, RegionID);
                ps.setString(2, name);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        public Optional<City> findCityByName(String RegionID, String name) {
            String query = "SELECT codecity, namecity, codereg FROM region WHERE (codereg = ? && namecity = ?)";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, RegionID);
                ps.setString(2, name);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        City city = new City(
                                rs.getString("codecity"),
                                rs.getString("namecity"),
                                rs.getString("codereg"));
                        return Optional.of(city);
                    }
    
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Optional.empty();
        }
        @Override
        public Optional<City> findCityByCode(String CityID) {
            String query = "SELECT codecity, namecity, codereg FROM City WHERE codecity=?";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, CityID);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        City City = new City(
                                rs.getString("codecity"),
                                rs.getString("namecity"),
                                rs.getString("codereg"));
                        return Optional.of(City);
                    }
    
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Optional.empty();
        
        }
        @Override
        public void updateCity(City City) {
            String query = "UPDATE City SET coderegion = ?, namecity = ? WHERE codecity = ?";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, City.getCodereg());
                ps.setString(2, City.getNamecity());
                ps.setString(3, City.getCodecity());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } 
        }
    
