package com.mainpharmacy.unitmeasurement.infraestructure;

import com.mainpharmacy.unitmeasurement.domain.entity.UnitMeasurement;
import com.mainpharmacy.unitmeasurement.domain.service.UnitMeasurementService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class UnitMeasurementRepository implements UnitMeasurementService {
    private Connection connection;

        public UnitMeasurementRepository() {
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
    public void createUnitMeasurement(UnitMeasurement unitmeasurement) {
            try {
            String query = "INSERT INTO unitmeasurement (idum, nameum) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, unitmeasurement.getId());
            ps.setString(2, unitmeasurement.getDescriptionmode());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UnitMeasurement deleteUnitMeasurement(String Name) {
        String query = "DELETE FROM unitmeasurement WHERE nameum = ?";
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
    public Optional<UnitMeasurement> findUnitMeasurementByName(String Name) {
        String query = "SELECT idum, nameum FROM unitmeasurement WHERE nameum = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, Name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    UnitMeasurement unitmeasurement = new UnitMeasurement(
                            rs.getInt("idum"),
                            rs.getString("nameum"));
                    return Optional.of(unitmeasurement);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<UnitMeasurement> findUnitMeasurementByCode(int codeUnitMeasurement) {
        String query = "SELECT idum, nameum FROM unitmeasurement WHERE idum = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, codeUnitMeasurement);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    UnitMeasurement unitmeasurement = new UnitMeasurement(
                            rs.getInt("idum"),
                            rs.getString("nameum"));
                    return Optional.of(unitmeasurement);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }

    @Override
    public List<UnitMeasurement> findAllUnitMeasurement() {
                List<UnitMeasurement> countries = new ArrayList<>();
        String query = "SELECT idum, nameum FROM unitmeasurement";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    UnitMeasurement unitmeasurement = new UnitMeasurement(
                        rs.getInt("idum"),
                        rs.getString("nameum"));
                        countries.add(unitmeasurement);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public void updateUnitMeasurement(UnitMeasurement unitmeasurement) {
        String query = "UPDATE unitmeasurement SET nameum = ? WHERE idum = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, unitmeasurement.getDescriptionmode());
            ps.setInt(2, unitmeasurement.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 

}
