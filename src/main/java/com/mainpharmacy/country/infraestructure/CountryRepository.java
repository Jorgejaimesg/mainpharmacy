package com.mainpharmacy.country.infraestructure;

import com.mainpharmacy.country.domain.entity.Country;
import com.mainpharmacy.country.domain.service.CountryService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class CountryRepository implements CountryService {
    private Connection connection;

        public CountryRepository() {
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
    public void createCountry(Country country) {
            try {
            String query = "INSERT INTO country (codecountry, namecountry) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, country.getCodeCountry());
            ps.setString(2, country.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Country deleteCountry(String Name) {
        String query = "DELETE FROM country WHERE namecountry = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, Name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Country> findCountryByName(String Name) {
        String query = "SELECT codecountry, namecountry FROM country WHERE namecountry = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, Name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Country country = new Country(
                            rs.getString("codeCountry"),
                            rs.getString("namecountry"));
                    return Optional.of(country);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Country> findCountryByCode(String codeCountry) {
        String query = "SELECT codecountry, namecountry FROM country WHERE codecountry = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, codeCountry);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Country country = new Country(
                            rs.getString("codeCountry"),
                            rs.getString("namecountry"));
                    return Optional.of(country);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }

    @Override
    public List<Country> findAllCountry() {
                List<Country> countries = new ArrayList<>();
        String query = "SELECT codecountry, namecountry FROM country";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Country country = new Country(
                        rs.getString("codeCountry"),
                        rs.getString("namecountry"));
                        countries.add(country);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public void updateCountry(Country country) {
        String query = "UPDATE country SET namecountry = ? WHERE codeCountry = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, country.getName());
            ps.setString(2, country.getCodeCountry());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 

}
