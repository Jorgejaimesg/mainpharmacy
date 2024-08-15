package com.mainpharmacy.activeprinciple.infraestructure;

import com.mainpharmacy.activeprinciple.domain.entity.ActivePrinciple;
import com.mainpharmacy.activeprinciple.domain.service.ActivePrincipleService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class ActivePrincipleRepository implements ActivePrincipleService {
    private Connection connection;

        public ActivePrincipleRepository() {
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
    public void createActivePrinciple(ActivePrinciple activeprinciple) {
            try {
            String query = "INSERT INTO activeprinciple (idap, nameap) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, activeprinciple.getId());
            ps.setString(2, activeprinciple.getDescriptionmode());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ActivePrinciple deleteActivePrinciple(String Name) {
        String query = "DELETE FROM activeprinciple WHERE nameap = ?";
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
    public Optional<ActivePrinciple> findActivePrincipleByName(String Name) {
        String query = "SELECT idap, nameap FROM activeprinciple WHERE nameap = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, Name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ActivePrinciple activeprinciple = new ActivePrinciple(
                            rs.getInt("idap"),
                            rs.getString("nameap"));
                    return Optional.of(activeprinciple);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<ActivePrinciple> findActivePrincipleByCode(int codeActivePrinciple) {
        String query = "SELECT idap, nameap FROM activeprinciple WHERE idap = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, codeActivePrinciple);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ActivePrinciple activeprinciple = new ActivePrinciple(
                            rs.getInt("idap"),
                            rs.getString("nameap"));
                    return Optional.of(activeprinciple);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }

    @Override
    public List<ActivePrinciple> findAllActivePrinciple() {
                List<ActivePrinciple> countries = new ArrayList<>();
        String query = "SELECT idap, nameap FROM activeprinciple";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ActivePrinciple activeprinciple = new ActivePrinciple(
                        rs.getInt("idap"),
                        rs.getString("nameap"));
                        countries.add(activeprinciple);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public void updateActivePrinciple(ActivePrinciple activeprinciple) {
        String query = "UPDATE activeprinciple SET nameap = ? WHERE idap = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, activeprinciple.getDescriptionmode());
            ps.setInt(2, activeprinciple.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 

}
