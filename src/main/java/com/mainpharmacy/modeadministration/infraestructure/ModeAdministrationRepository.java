package com.mainpharmacy.modeadministration.infraestructure;

import com.mainpharmacy.modeadministration.domain.entity.ModeAdministration;
import com.mainpharmacy.modeadministration.domain.service.ModeAdministrationService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class ModeAdministrationRepository implements ModeAdministrationService {
    private Connection connection;

        public ModeAdministrationRepository() {
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
    public void createModeAdministration(ModeAdministration modeadministration) {
            try {
            String query = "INSERT INTO modeadministration (id, descriptionmode) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, modeadministration.getId());
            ps.setString(2, modeadministration.getDescriptionmode());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ModeAdministration deleteModeAdministration(String Name) {
        String query = "DELETE FROM modeadministration WHERE descriptionmode = ?";
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
    public Optional<ModeAdministration> findModeAdministrationByName(String Name) {
        String query = "SELECT id, descriptionmode FROM modeadministration WHERE descriptionmode = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, Name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ModeAdministration modeadministration = new ModeAdministration(
                            rs.getInt("id"),
                            rs.getString("descriptionmode"));
                    return Optional.of(modeadministration);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<ModeAdministration> findModeAdministrationByCode(int codeModeAdministration) {
        String query = "SELECT id, descriptionmode FROM modeadministration WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, codeModeAdministration);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ModeAdministration modeadministration = new ModeAdministration(
                            rs.getInt("id"),
                            rs.getString("descriptionmode"));
                    return Optional.of(modeadministration);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }

    @Override
    public List<ModeAdministration> findAllModeAdministration() {
                List<ModeAdministration> countries = new ArrayList<>();
        String query = "SELECT id, descriptionmode FROM modeadministration";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ModeAdministration modeadministration = new ModeAdministration(
                        rs.getInt("id"),
                        rs.getString("descriptionmode"));
                        countries.add(modeadministration);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public void updateModeAdministration(ModeAdministration modeadministration) {
        String query = "UPDATE modeadministration SET descriptionmode = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, modeadministration.getDescriptionmode());
            ps.setInt(2, modeadministration.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 

}
